package com.elirex.patterns.factorymethodpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-07.
 */
class Product : IProduct {

    override fun functionA() {
        println("Do functionA")
    }

    override fun functionB() {
        println("Do functionB")
    }
}