package com.elirex.patterns.proxypattern

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method



/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-04.
 */

class InvocationHandlerImp(private val target: Any? = null) : InvocationHandler {

    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
        return method.invoke(target, *(args ?: arrayOfNulls<Any>(0)))
    }

}