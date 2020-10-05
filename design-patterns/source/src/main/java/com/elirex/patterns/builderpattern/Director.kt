package com.elirex.patterns.builderpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-28.
 */
class Director {


    private val productABuilder: ProductABuilder by lazy {
        ProductABuilder()
    }

    private val productBBuilder: ProductBBuilder by lazy {
        ProductBBuilder()
    }

    fun getProductA() : ProductA {
        return productABuilder
            .setColor("Red")
            .setFont("Aria")
            .build() as ProductA
    }

    fun getProductB() : ProductB {
        return productBBuilder
            .setColor("Green")
            .setFont("Chaucer")
            .build() as ProductB
    }
}