package com.elirex.patterns.proxypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-04.
 */
class Proxy(private var subject: RealSubject? = null) : Subject {

    override fun request() {
        subject?.request()
    }

}