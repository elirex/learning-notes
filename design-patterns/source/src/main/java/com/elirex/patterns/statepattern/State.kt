package com.elirex.patterns.statepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-29.
 */
abstract class State {

    lateinit var context: Context

    abstract fun handle()

}