package com.elirex.patterns.abstractfactorypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-14.
 */

abstract class ProductA {

    fun function() {
        println("Do ${ProductA::class.java.name}'s common function.")
    }

    abstract fun method()

}

abstract class ProductB {

    fun function() {
        println("Do ${ProductB::class.java.name}'s common function.")
    }

    abstract fun method()

}

class ProductA1 : ProductA() {

    override fun method() {
        println("Do ${ProductA1::class.java.name} method.")
    }

}

class ProductA2 : ProductA() {

    override fun method() {
        println("Do ${ProductA2::class.java.name} method.")
    }

}

class ProductB1 : ProductB() {

    override fun method() {
        println("Do ${ProductB1::class.java.name} method.")
    }

}

class ProductB2 : ProductB() {

    override fun method() {
        println("Do ${ProductB2::class.java.name} method.")
    }

}
