package com.elirex.patterns.iteratorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-09-30.
 */

fun main(args: Array<String>) {
    val aggregate = ConcreteAggregate<String>()
    aggregate.add("abc")
    aggregate.add("def")
    aggregate.add("123")

    val iterator = aggregate.iterator()

    while (iterator.hasNext()) {
        println(iterator.next())
    }
}