package com.elirex.patterns.prototypepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-09.
 */

fun main(args: Array<String>) {
    val shallow = ShallowPrototype()

    shallow.setValue("ABC")
    val cloneShallow = shallow.clone()
    cloneShallow.setValue("DEF")
    println(shallow.getValue())

    val deep = DeepPrototype()
    deep.setValue("ABC")
    val copyDeep = deep.clone()
    copyDeep.setValue("DEF")
    println(deep.getValue())
}

