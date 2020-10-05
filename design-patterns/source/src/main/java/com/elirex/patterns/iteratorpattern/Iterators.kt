package com.elirex.patterns.iteratorpattern

import java.util.*


/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-09-30.
 */

interface Iterator<E> {

    fun next(): E?

    fun hasNext(): Boolean

}

class ConcreteIterator<E>(private var vector: Vector<E>) : Iterator<E> {

    var cursor: Int = 0
    private set

    override fun hasNext(): Boolean {
        return (cursor == vector.size).not()
    }

    override fun next(): E? {
        return if (hasNext()) return vector[cursor++] else return null
    }

}