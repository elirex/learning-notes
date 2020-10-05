package com.elirex.patterns.strategypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-17.
 */
class Context (var strategy: Strategy){

    fun operation() {
        strategy.algorithm()
    }
}