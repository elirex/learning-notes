package com.elirex.patterns.templatemethodpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-30.
 */
abstract class Template {

    protected abstract fun doSomething()

    protected abstract fun doAnything()

    fun templateMethod() {
        doAnything()
        doSomething()
    }

}