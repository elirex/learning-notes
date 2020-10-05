package com.elirex.patterns.builderpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-28.
 */


interface Product {

    fun setColor(color: String)
    fun setFont(font: String)
    fun getColor(): String
    fun getFont(): String

}

class ProductA : Product {

    private var color: String = ""
    private var font: String = ""

    override fun setColor(color: String) {
        this.color = color
    }

    override fun setFont(font: String) {
        this.font = font
    }

    override fun getColor(): String {
        return color
    }

    override fun getFont(): String {
        return font
    }

}

class ProductB : Product {

    private var color: String = ""
    private var font: String = ""

    override fun setColor(color: String) {
        this.color = color
    }

    override fun setFont(font: String) {
        this.font = font
    }

    override fun getColor(): String {
        return color
    }

    override fun getFont(): String {
        return font
    }
}