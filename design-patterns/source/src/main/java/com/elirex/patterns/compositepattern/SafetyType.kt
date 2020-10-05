package com.elirex.patterns.compositepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-08.
 */

abstract class ComponentSafety(name: String) {

    var name: String
    private set

    init {
        this.name = name
    }

}

class CompositeSafety(name: String) : ComponentSafety(name) {

    protected val children: MutableSet<ComponentSafety> by lazy {
        mutableSetOf<ComponentSafety>()
    }

    fun add(child: ComponentSafety) {
        if (!children.contains(child)) {
            children.add(child)
        }
    }

    fun remove(child: ComponentSafety) {
        if (children.contains(child)) {
            children.remove(child)
        }
    }

    fun getChildren(): List<ComponentSafety> {
        return children.toList()
    }

}

class LeafSafety(name: String) : ComponentSafety(name)

