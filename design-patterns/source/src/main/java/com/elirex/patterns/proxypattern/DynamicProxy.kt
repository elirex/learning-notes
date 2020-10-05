package com.elirex.patterns.proxypattern

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-04.
 */
class DynamicProxy {

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun <T> newProxyInstance(loader: ClassLoader, interfaces: Array<Class<*>>, handler: InvocationHandler): T {
            return Proxy.newProxyInstance(loader, interfaces, handler) as T
        }

    }








}