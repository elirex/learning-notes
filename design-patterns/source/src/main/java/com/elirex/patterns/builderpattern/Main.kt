package com.elirex.patterns.builderpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-28.
 */

fun main(args: Array<String>) {
    val director = Director()

    director.getProductA().run {
        println("ProductA color is ${getColor()}")
        println("ProductA font is ${getFont()}")
    }
    director.getProductB().run {
        println("ProductB color is ${getColor()}")
        println("ProductB font is ${getFont()}")
    }
}