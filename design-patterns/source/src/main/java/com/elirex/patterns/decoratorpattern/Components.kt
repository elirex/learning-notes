package com.elirex.patterns.decoratorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-11.
 */
interface Component {

    fun operation()
}

class ConcreteComponent : Component {

    override fun operation() {
        println("On ConcreteComponent's operation()")
    }
}