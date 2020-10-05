package com.elirex.patterns.adapterpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-21.
 */

fun main(args: Array<String>) {

    val objectTarget = ObjectAdapter()
    objectTarget.setObjectAdaptee(ObjectAdpatee())
    objectTarget.operation()

    val classTarget = ClassAdapter()
    classTarget.operation()

}