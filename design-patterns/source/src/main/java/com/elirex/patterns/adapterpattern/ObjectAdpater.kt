package com.elirex.patterns.adapterpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-21.
 */

class ObjectAdpatee {
    fun specificOperation() {
        println("Run the ObjectAdaptee's specificOperation()")
    }
}

class ObjectAdapter : Target {

    private lateinit var objectAdpatee: ObjectAdpatee

    fun setObjectAdaptee(adpatee: ObjectAdpatee) {
        objectAdpatee = adpatee
    }

    override fun operation() {
        objectAdpatee.specificOperation()
    }

}