package com.elirex.patterns.builderpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-28.
 */

abstract class Builder {

    abstract fun setColor(color: String): Builder
    abstract fun setFont(font: String): Builder
    abstract fun build(): Product

}


class ProductABuilder : Builder() {

    private val product = ProductA()
    override fun setColor(color: String): Builder = apply { product.setColor(color) }

    override fun setFont(font: String): Builder = apply { product.setFont(font) }

    override fun build(): Product {
        return ProductA().apply {
            setColor(product.getColor())
            setFont(product.getFont())
        }
    }
}

class ProductBBuilder : Builder() {

    private val product = ProductB()
    override fun setColor(color: String): Builder = apply { product.setColor(color) }

    override fun setFont(font: String): Builder = apply { product.setFont(font) }

    override fun build(): Product {
        return ProductB().apply {
            setColor(product.getColor())
            setFont(product.getFont())
        }
    }
}
