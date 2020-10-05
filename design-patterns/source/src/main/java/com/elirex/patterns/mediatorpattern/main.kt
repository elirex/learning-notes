package com.elirex.patterns.mediatorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-25.
 */

fun main(args: Array<String>) {
    val mediator = ConcreteMediator()
    val storageA = StorageA(mediator)
    val storageB = StorageB(mediator)

    storageA.execute(1)
    storageB.execute(1)

}