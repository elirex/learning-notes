package com.elirex.patterns.decoratorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-11.
 */

fun main(args: Array<String>) {
    var component: Component = ConcreteComponent()
    component = ConcreteDecoratorA(component)
    component = ConcreteDecoratorB(component)
    component.operation()
}
