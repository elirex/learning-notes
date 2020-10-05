package com.elirex.patterns.adapterpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-21.
 */

open class ClassAdaptee {

    fun specificOperation() {
        println("Run the ClassAdaptee's specificOperation().")
    }
}

class ClassAdapter : Target, ClassAdaptee() {

    override fun operation() {
        specificOperation()
    }



}