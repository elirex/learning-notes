package com.elirex.patterns.commandpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-15.
 */

abstract class Command (protected val receiver: Receiver) {

    abstract fun execute();

}

class CommandA(receiver: Receiver) : Command(receiver) {

    override fun execute() {
        receiver.action("CommandA executes")
    }
}

class CommandB(receiver: Receiver) : Command(receiver) {

    override fun execute() {
        receiver.action("CommandB executes")
    }
}
