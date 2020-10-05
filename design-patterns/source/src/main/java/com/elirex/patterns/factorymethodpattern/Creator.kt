package com.elirex.patterns.factorymethodpattern


/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-07.
 */

abstract class Creator {

    abstract fun <T: IProduct> factoryMethod(c: Class<T>): T
}