package com.elirex.algorithm.graph

import com.elirex.algorithm.Bag

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/1.
 */

class Graph {
    val vertices: Int
    private var _edges: Int
    private val edges: Int
        get() = _edges
    private var adjacencyLists: Array<Bag<Int>>


    /**
     * Construct an empty graph with vertices and 0 edges.
     *
     * @param vertices is number of vertices
     * @throws IllegalArgumentException if vertices < 0
     */
    constructor(vertices: Int) {
        this.vertices = vertices
        verifyVertices()
        _edges = 0
        adjacencyLists = Array(vertices) { Bag<Int>() }
    }

    /**
     * Adds the undirected edge v - u to this graph.
     *
     * @param v one vertex in the edge
     * @param u other vertex in the edge
     * @throws IllegalArgumentException unless both 0 <= v < vertices and 0 <= u < vertices
     */
    fun addEdge(v: Int, u: Int): Graph = apply {
        validateVertex(v)
        validateVertex(u)
        _edges++
        adjacencyLists[v].add(u)
        adjacencyLists[u].add(v)
    }

    /**
     * Returns the vertices adjacent to vertex.
     *
     * @param vertex
     * @return the vertices adjacent ot vertex, as an iterable
     * @throws IllegalArgumentException unless 0 <= vertex < vertices
     */
    fun getAdjacencyByVertex(vertex: Int): Iterable<Int> {
        validateVertex(vertex)
        return adjacencyLists[vertex]
    }

    /**
     * Returns the degree of vertex.
     *
     * @param vertex
     * @return the degree of vertex
     * @throws IllegalArgumentException unless 0 <= vertex < vertices
     */
    fun degree(vertex: Int): Int {
        validateVertex(vertex)
        return adjacencyLists[vertex].size
    }

    override fun toString(): String {
        return StringBuilder().apply {
            append("$vertices vertices, $edges edges")
            append("\n")
            for (v in 0 until vertices) {
                append("$v: ")
                for (u in adjacencyLists[v]) {
                    append("$u ")
                }
                append("\n")
            }
        }.toString()
    }

    private fun validateVertex(vertex: Int) {
        if (vertex < 0 || vertex >= vertices) {
            throw IllegalArgumentException("The vertex($vertex) is not between 0 and ${vertices - 1}")
        }
    }

    private fun verifyVertices() {
        if (vertices < 0) {
            throw IllegalArgumentException("The number of vertices must be positive")
        }
    }

}

fun main(args: Array<String>) {
    val graph = Graph(10)
        .addEdge(0, 1)
        .addEdge(2, 5)
        .addEdge(9, 1)
    println(graph)
    println(graph.degree(1))
}

