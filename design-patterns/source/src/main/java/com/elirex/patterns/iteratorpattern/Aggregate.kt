package com.elirex.patterns.iteratorpattern

import java.util.*

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-09-30.
 */


interface Aggregate<E> {

    fun add(element: E)

    fun remove(element: E)

    fun iterator(): Iterator<E>

}


class ConcreteAggregate<E> : Aggregate<E> {

    private val vector: Vector<E> by lazy { Vector<E>() }

    override fun add(element: E) {
        vector.add(element)
    }

    override fun remove(element: E) {
        vector.remove(element)
    }

    override fun iterator(): Iterator<E> {
        return ConcreteIterator(vector)
    }

}