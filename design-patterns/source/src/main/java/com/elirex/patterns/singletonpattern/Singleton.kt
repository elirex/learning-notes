package com.elirex.patterns.singletonpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-21.
 */
class Singleton private constructor() {

    private object Holder {
        val instance = Singleton()
    }

    companion object {

        fun getInstance(): Singleton =
            Holder.instance

    }

    fun run() {
        println("Do something.")
    }

}