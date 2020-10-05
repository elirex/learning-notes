package com.elirex.patterns.strategypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-17.
 */

interface Strategy {

    fun algorithm()

}

class StrategyA : Strategy {

    override fun algorithm() {
        println("Run StrategyA's algorithm.")
    }

}

class StrategyB : Strategy {

    override fun algorithm() {
        println("Run StrategyB's algorithm.")
    }

}
