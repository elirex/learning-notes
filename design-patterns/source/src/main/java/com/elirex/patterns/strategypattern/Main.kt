package com.elirex.patterns.strategypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-17.
 */

fun main(args: Array<String>) {

    val context: Context = Context(StrategyA())
    context.operation()

    context.strategy = StrategyB()
    context.operation()

}