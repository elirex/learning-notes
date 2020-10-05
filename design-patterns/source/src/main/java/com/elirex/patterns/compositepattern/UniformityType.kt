package com.elirex.patterns.compositepattern

import java.lang.UnsupportedOperationException

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-08.
 */

abstract class Component(name: String) {

    var name: String
    private set

    init {
        this.name = name
    }

    protected val children: MutableSet<Component> by lazy {
        mutableSetOf<Component>()
    }

    abstract fun add(child: Component)
    abstract fun remove(child: Component)
    abstract fun getChildren(): List<Component>
}

class Composite(name: String) : Component(name) {

    override fun add(child: Component) {
        if (!children.contains(child)) {
            children.add(child)
        }
    }

    override fun remove(child: Component) {
        if (children.contains(child)) {
            children.remove(child)
        }
    }

    override fun getChildren(): List<Component> {
        return children.toList()
    }

}

class Leaf(name: String) : Component(name) {

    override fun add(child: Component) {
        throw UnsupportedOperationException("The Leaf can't add child.")
    }

    override fun remove(child: Component) {
        throw UnsupportedOperationException("The Leaf can't remove child.")
    }

    override fun getChildren(): List<Component> {
        throw UnsupportedOperationException("The Leaf no children.")
    }
}