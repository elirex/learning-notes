package com.elirex.patterns.factorymethodpattern



/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-07-07.
 */

class ConcreteCreator : Creator() {

    override fun <T : IProduct> factoryMethod(c: Class<T>): T {
        return Class.forName(c.name).newInstance() as T
    }

}