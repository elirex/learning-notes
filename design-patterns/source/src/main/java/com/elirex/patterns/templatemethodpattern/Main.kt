package com.elirex.patterns.templatemethodpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-30.
 */

fun main(args: Array<String>) {
    val classA = ConcreteClassA()
    val classB = ConcreteClassB()
    doing(classA)
    doing(classB)
}

private fun doing(request: Template) {
    request.templateMethod()
}