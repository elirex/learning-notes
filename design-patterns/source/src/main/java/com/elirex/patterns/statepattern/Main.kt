package com.elirex.patterns.statepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-29.
 */

fun main(args: Array<String>) {

    val context = Context().apply {
        setCurrentState(Context.STATE1)
    }

    context.handle()
    context.handle()

}

