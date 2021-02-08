package com.elirex.algorithm.graph

import com.elirex.algorithm.Bag

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/1.
 */

class UndirectedGraph(vertices: Int) : Graph(vertices) {

    override fun addEdge(v: Int, u: Int): Graph = apply {
        super.addEdge(v, u)
        adjacencyList[v].add(u)
        adjacencyList[u].add(v)
        _edges++
    }

    override fun degree(vertex: Int): Int {
        validateVertex(vertex)
        return adjacencyList[vertex].size
    }


}

fun main(args: Array<String>) {
    val graph = UndirectedGraph(10)
        .addEdge(0, 1)
        .addEdge(2, 5)
        .addEdge(9, 1)
    println(graph)
    println(graph.degree(1))
}

