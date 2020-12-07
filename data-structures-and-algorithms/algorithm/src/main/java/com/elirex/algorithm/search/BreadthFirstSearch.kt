package com.elirex.algorithm.search

import com.elirex.algorithm.graph.Graph
import java.util.*
import kotlin.collections.ArrayDeque

/**
 * The BreadthFirstSearch class represents a data type
 * for determining the vertices connected to
 * a given source vertex in an undirected graph.
 *
 * Time complexity: O(E + V) where
 *  E is the number of edges in the graph.
 *  V is the number of vertices in the graph.
 * Space complexity: O(V) where V is the number of vertices in the graph.
 *
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/7.
 */
class BreadthFirstSearch {
    private val marked: Array<Boolean>

    private var _count: Int = 0

    /**
     * Returns the number of vertices connected to the source vertex.
     * @return the number of vertices connected to the source vertex
     */
    val count: Int
        get() = _count

    /**
     *  Computes the vertices in a graph that are connected to
     *  the source vertex.
     *  @param graph
     *  @param sourceVertex
     *  @throws IllegalArgumentException unless 0 <= the source vertex < vertices
     */
    @ExperimentalStdlibApi
    constructor(graph: Graph, sourceVertex: Int) {
        marked = Array(graph.vertices) { false }
        validateVertex(sourceVertex)
        bfs(graph, sourceVertex)
    }

    /**
     * Is there a path between the source vertex and vertex?
     * @param vertex the target vertex
     * @return true if there is a path, otherwise
     * @throws IllegalArgumentException unless 0 <= target vertex < verteices
     */
    fun marked(vertex: Int): Boolean {
        validateVertex(vertex)
        return marked[vertex]
    }

    @ExperimentalStdlibApi
    private fun bfs(graph: Graph, sourceVertex: Int) {
        val adjacencies: Array<Iterator<Int>> = Array(graph.vertices) { vertex ->
            graph.getAdjacencyByVertex(vertex).iterator()
        }

        val queue = ArrayDeque<Int>()
        marked[sourceVertex] = true
        _count++
        queue.add(sourceVertex)
        while (queue.isNotEmpty()) {
            val v = queue.removeFirst()
            while (adjacencies[v].hasNext()) {
                val u = adjacencies[v].next()
                if (!marked[u]) {
                    marked[u] = true
                    _count++
                    queue.add(u)
                }
            }
        }

    }

    private fun validateVertex(vertex: Int) {
        if (vertex < 0 || vertex >= marked.size) {
            throw IllegalArgumentException("Vertex ($vertex) must be between 0 and ${marked.size - 1}")
        }
    }
}

@ExperimentalStdlibApi
fun main() {
    val graph = Graph(8)
        .addEdge(0, 1)
        .addEdge(0, 2)
        .addEdge(1, 3)
        .addEdge(2, 1)
        .addEdge(2, 5)
        .addEdge(3, 4)
        .addEdge(3, 5)
        .addEdge(5, 1)
        .addEdge(6, 4)
        .addEdge(6, 7)
        .addEdge(7, 6)

    val bfs: BreadthFirstSearch = BreadthFirstSearch(graph, 0)
    search(bfs, graph)
}

private fun search(bfs: BreadthFirstSearch, graph: Graph) {
    for (v in 0 until graph.vertices) {
        if (bfs.marked(v)) print("$v ")
    }
    println()
    if (bfs.count != graph.vertices) {
        println("NOT connected.")
    } else {
        println("Connected.")
    }
}