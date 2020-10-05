package com.elirex.patterns.proxypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-04.
 */

fun main(args: Array<String>) {
    val proxy = Proxy(RealSubject())
    proxy.request()

    val subject: Subject = RealSubject()
    val invocationHandler = InvocationHandlerImp(subject)

    val dynamicProxy: Subject = DynamicProxy.newProxyInstance(
        subject.javaClass.classLoader,
        subject.javaClass.interfaces,
        invocationHandler)

    dynamicProxy.request()
}