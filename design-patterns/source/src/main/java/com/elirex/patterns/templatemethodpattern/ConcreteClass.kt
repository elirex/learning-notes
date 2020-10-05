package com.elirex.patterns.templatemethodpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-30.
 */

class ConcreteClassA : Template() {

    override fun doSomething() {
        println("${ConcreteClassA::class.java.name} doSomething()")
    }

    override fun doAnything() {
        println("${ConcreteClassA::class.java.name} doAnything()")
    }

}

class ConcreteClassB : Template() {

    override fun doSomething() {
        println("${ConcreteClassB::class.java.name} doSomething()")
    }

    override fun doAnything() {
        println("${ConcreteClassB::class.java.name} doAnything()")
    }

}
