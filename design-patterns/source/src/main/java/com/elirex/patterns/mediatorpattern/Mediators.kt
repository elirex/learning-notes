package com.elirex.patterns.mediatorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-25.
 */

abstract class Mediator {

    protected val storageA: StorageA by lazy { StorageA(this) }
    protected val storageB: StorageB by lazy { StorageB(this) }

    abstract fun action(name: String, delta: Int)

}


class ConcreteMediator: Mediator() {

    override fun action(name: String, delta: Int) {
        when (name) {
            "increase" -> increase(delta)
            "decrease" -> decrease(delta)
            else -> println("This action not found.")
        }
    }

    private fun increase(delta: Int) {
        storageA.increase(delta)
    }

    private fun decrease(delta: Int) {
        storageB.decrease(delta)
    }

}