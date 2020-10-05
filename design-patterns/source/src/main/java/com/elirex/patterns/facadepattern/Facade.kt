package com.elirex.patterns.facadepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-29.
 */
class Facade {

    private val systemA: SystemA by lazy { SystemA() }
    private val systemB: SystemB by lazy { SystemB() }
    private val systemC: SystemC by lazy { SystemC() }

    fun execute() {
        systemA.function()
        systemB.function()
        systemC.function()
    }
}