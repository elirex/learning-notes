package com.elirex.patterns.mediatorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-25.
 */

abstract class Storage(protected val mediator: Mediator) {

    companion object {
        var value = 0
    }

}


class StorageA(mediator: Mediator) : Storage(mediator) {

    fun increase(delta: Int) {
        value += delta
        println("StorageA executes the increase(), value = $value")
    }

    fun execute(delta: Int) {
        mediator.action("increase", delta)
    }

}

class StorageB(mediator: Mediator) : Storage(mediator) {

    fun decrease(delta: Int) {
        value -= delta
        println("StorageB executes the decrease(), value = $value")
    }

    fun execute(delta: Int) {
        mediator.action("decrease", delta)
    }

}