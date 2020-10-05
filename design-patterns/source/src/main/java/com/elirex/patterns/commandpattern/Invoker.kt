package com.elirex.patterns.commandpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-15.
 */
class Invoker {

    private var command: Command? = null

    fun setCommand(cmd: Command) {
        command = cmd
    }

    fun action() {
        command?.execute()
    }

}