package com.elirex.patterns.compositepattern

import java.lang.UnsupportedOperationException

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-09.
 */

fun main(args: Array<String>) {
    runUniformityType()
    runSafetyType()

}

fun runUniformityType() {
    println("Composite pattern uniformity type")
    val root: Component = Composite("Root")
    val childA: Component = Leaf("ChildA")
    root.add(childA)

    println(root.name)
    for (component in root.getChildren()) {
        println(component.name)
        try {
            component.getChildren()
        } catch (e: UnsupportedOperationException) {
            println(e)
        }
    }
}

fun runSafetyType() {
    println("Composite pattern Safety type")
    val root = CompositeSafety("Root")
    val childA = LeafSafety("ChildA")
    root.add(childA)

    println(root.name)
    for (component in root.getChildren()) {
        println(component.name)
        if (component is CompositeSafety) {
            component.getChildren()
        }
    }
}
