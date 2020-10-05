package com.elirex.patterns.statepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-29.
 */

class ConcreteState1 : State() {

    override fun handle() {
        println("Handling ${ConcreteState1::class.java.name}")
        context.setCurrentState(Context.STATE2)
    }

}

class ConcreteState2 : State() {

    override fun handle() {
        println("Handling ${ConcreteState2::class.java.name}")
        context.setCurrentState(Context.STATE1)
    }

}
