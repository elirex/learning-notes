package com.elirex.patterns.abstractfactorypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-14.
 */

abstract class Factory {

    abstract fun createProductA(): ProductA
    abstract fun createProductB(): ProductB

}

class Factory1 : Factory() {

    override fun createProductA(): ProductA = ProductA1()

    override fun createProductB(): ProductB = ProductB1()

}

class Factory2 : Factory() {

    override fun createProductA(): ProductA = ProductA2()

    override fun createProductB(): ProductB = ProductB2()

}
