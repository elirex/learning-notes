package com.elirex.patterns.abstractfactorypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-14.
 */

fun main(args: Array<String>) {
   val factory1 = Factory1()
   val factory2 = Factory2()

   val a1 = factory1.createProductA()
   val b1 = factory1.createProductB()

   val a2 = factory2.createProductA()
   val b2 = factory2.createProductB()

   a1.function()
   a1.method()

   a2.function()
   a2.method()

   b1.function()
   b1.method()

   b2.function()
   b2.method()
}