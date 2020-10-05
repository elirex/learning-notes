package com.elirex.patterns.statepattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-06-29.
 */
class Context {

    companion object {

        val STATE1 = ConcreteState1()
        val STATE2 = ConcreteState2()

    }

    private lateinit var currentState: State

    fun getCurrentState(): State = currentState

    fun setCurrentState(state: State) {
        currentState = state
        currentState.context = this
    }

    fun handle() {
        currentState.handle()
    }

}