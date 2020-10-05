package com.elirex.patterns.chainofresponsibilitypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-25.
 */

fun main(args: Array<String>) {
    val handlerA = HandlerA()
    val handlerB = HandlerB()

    handlerA.nextHandler = handlerB

    handlerA.handleMessage(Request("for A", level = Handler.LEVEL_1))?.let {
        println(it.msg)
    }

    handlerA.handleMessage(Request("for B", level = Handler.LEVEL_2))?.let {
        println(it.msg)
    }

    if (handlerA.handleMessage(Request("for None")) == null) {
        println("Can't handle.")
    }

}
