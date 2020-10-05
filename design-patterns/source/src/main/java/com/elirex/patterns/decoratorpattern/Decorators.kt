package com.elirex.patterns.decoratorpattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-11.
 */

abstract class Decorator(private val component: Component) : Component {

    override fun operation() {
        component.operation()
    }

}

class ConcreteDecoratorA(component: Component) : Decorator(component) {

    override fun operation() {
        selfOperation()
        super.operation()
    }

    private fun selfOperation() {
        println("On ConcreteDecoratorA's selfOperation()")
    }
}

class ConcreteDecoratorB(component: Component) : Decorator(component) {

    override fun operation() {
        super.operation()
        selfOperation()
    }

    private fun selfOperation() {
        println("On ConcreteDecoratorB's selfOperation()")
    }
}
