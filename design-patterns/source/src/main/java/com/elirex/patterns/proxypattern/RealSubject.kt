package com.elirex.patterns.proxypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-04.
 */
class RealSubject : Subject {

    override fun request() {
        println("RealSubject runs request.")
    }

}