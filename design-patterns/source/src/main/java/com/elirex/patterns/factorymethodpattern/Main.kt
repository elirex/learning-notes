package com.elirex.patterns.factorymethodpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-07.
 */

fun main(args: Array<String>) {
    val creator = ConcreteCreator()
    val product: IProduct = creator.factoryMethod(Product::class.java)
    product.functionA()
    product.functionB()
}