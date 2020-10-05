package com.elirex.patterns.prototypepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-09.
 */
class ShallowPrototype : Cloneable {

    private val arrayList: MutableList<String> by lazy {
        mutableListOf<String>()
    }

    fun setValue(value: String) {
        arrayList.add(value);
    }

    fun getValue(): List<String> = arrayList

    @Throws(CloneNotSupportedException::class)
    override public fun clone(): ShallowPrototype {
        return super.clone() as ShallowPrototype
    }

}