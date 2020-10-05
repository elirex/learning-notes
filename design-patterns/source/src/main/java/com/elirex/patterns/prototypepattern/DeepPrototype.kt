package com.elirex.patterns.prototypepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-09.
 */
class DeepPrototype : Cloneable {

    private var arrayList = ArrayList<String>()

    fun setValue(value: String) {
        arrayList.add(value);
    }

    fun getValue(): List<String> = arrayList

    @Throws(CloneNotSupportedException::class)
    override public fun clone(): DeepPrototype {
        val copy = super.clone() as DeepPrototype
        copy.arrayList =  arrayList.clone() as ArrayList<String>
        return copy
    }

}