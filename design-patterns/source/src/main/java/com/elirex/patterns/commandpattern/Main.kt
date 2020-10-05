package com.elirex.patterns.commandpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-15.
 */

fun main(args: Array<String>) {
    val invoker = Invoker()
    val receiver = Receiver()
    invoker.setCommand(CommandA(receiver))
    invoker.action()
    invoker.setCommand(CommandB(receiver))
    invoker.action()
}