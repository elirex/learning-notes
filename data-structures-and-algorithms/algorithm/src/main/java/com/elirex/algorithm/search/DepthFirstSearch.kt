package com.elirex.algorithm.search

import com.elirex.algorithm.graph.Graph
import java.util.*

/**
 * The DepthFirstSearch class represents a data type for determining
 * the vertices connected to a given source vertex s in an undirected graph.
 *
 * Time complexity: O(E + V), where
 *  E is the number of edges in the graph
 *  V is the number of vertices in the graph
 * Space complexity: O(V) where V is the number of vertices in the graph
 *
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/3.
 */
abstract class DepthFirstSearch {
    protected val marked: Array<Boolean>

    protected var _count: Int = 0
    /**
     *  Returns the number of vertices connected to the source vertex.
     *
     *  @return the number of vertices connected to the source vertex
     */
    val count: Int
        get() = _count

    /**
     * Computes the vertices in graph that are connected to the source vertex.
     *
     * @param graph
     * @param sourceVertex
     * @throws IllegalArgumentException unless 0 <= the source vertex < vertices
     */
    constructor(graph: Graph, sourceVertex: Int) {
        marked = Array(graph.vertices) { false }
        validateVertex(sourceVertex)
        dfs(graph, sourceVertex)
    }

    /**
     * Is there a path between the source vertex and vertex?
     *
     * @param vertex the target vertex
     * @return true if there is a path, otherwise
     * @throws IllegalArgumentException unless 0 <= target vertex < vertices
     */
    fun marked(vertex: Int): Boolean {
        validateVertex(vertex)
        return marked[vertex]
    }

    // Depth first search from the source vertex
    protected abstract fun dfs(graph: Graph, sourceVertex: Int)


    // Throw an IllegalArgumentException unless 0 <= vertex < vertices.
    private fun validateVertex(vertex: Int) {
        if (vertex < 0 || vertex >= marked.size) {
            throw IllegalArgumentException("Vertex ($vertex) must be between 0 and ${marked.size - 1}")
        }
    }

}

class RecursiveDFS : DepthFirstSearch {

    constructor(graph: Graph, sourceVertex: Int) : super(graph, sourceVertex)

    override fun dfs(graph: Graph, sourceVertex: Int) {
        _count++
        marked[sourceVertex] = true
        for (u in graph.getAdjacencyByVertex(sourceVertex)) {
            if (!marked[u]) dfs(graph, u)
        }
    }
}

class IterativeDFS : DepthFirstSearch {

    constructor(graph: Graph, sourceVertex: Int) : super(graph, sourceVertex)

    override fun dfs(graph: Graph, sourceVertex: Int) {
        // To be able to iterate over each adjacency list,
        // keeping track of which vertex in each adjacency list needs
        // to be explored next.
        val adjacencies: Array<Iterator<Int>> = Array(graph.vertices) { vertex ->
            graph.getAdjacencyByVertex(vertex).iterator()
        }

        // Depth first search using an explicit stack
        val stack: Stack<Int>  = Stack<Int>()
        marked[sourceVertex] = true
        stack.push(sourceVertex)
        while (stack.isNotEmpty()) {
            val v = stack.peek()
            if (adjacencies[v].hasNext()) {
                val u = adjacencies[v].next()
                if (!marked[u]) {
                    // Discovered vertex u for the first time.
                    marked[u] = true
                    stack.push(u)
                }
            } else {
                stack.pop()
            }
        }
    }
}

fun main() {
    val graph = Graph(10)
        .addEdge(0, 1)
        .addEdge(2, 3)
        .addEdge(4, 5)
        .addEdge(6, 7)
        .addEdge(8, 9)
        .addEdge(9, 0)

    val recursiveDFS: DepthFirstSearch = RecursiveDFS(graph, 0)
    val iterativeDFS: DepthFirstSearch = IterativeDFS(graph, 0)
    search(recursiveDFS, graph)
    println()
    search(iterativeDFS, graph)

}

private fun search(dfs: DepthFirstSearch, graph: Graph) {
    for (v in 0 until graph.vertices) {
        if (dfs.marked(v)) print("$v ")
    }
    println()
    if (dfs.count != graph.vertices) {
        println("NOT connected.")
    } else {
        println("Connected.")
    }
}