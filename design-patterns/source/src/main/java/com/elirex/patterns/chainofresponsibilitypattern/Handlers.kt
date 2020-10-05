package com.elirex.patterns.chainofresponsibilitypattern

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2019-08-25.
 */

abstract class Handler {

    companion object {
        const val LEVEL_UNKNOWN = -1
        const val LEVEL_1 = 1
        const val LEVEL_2 = 2
    }

    var nextHandler: Handler? = null

    fun handleMessage(request: Request): Response? {

        if (getHandleLevel().equals(request.level)) {
            return echo(request)
        }
        return nextHandler?.run {
            handleMessage(request)
        }
    }

    abstract fun getHandleLevel(): Int

    abstract fun echo(request: Request): Response?

}

class HandlerA : Handler() {

    override fun getHandleLevel(): Int = Handler.LEVEL_1

    override fun echo(request: Request): Response {
        return Response("HandlerA response ${request.msg}")
    }

}

class HandlerB : Handler() {

    override fun getHandleLevel(): Int = Handler.LEVEL_2

    override fun echo(request: Request): Response {
        return Response("HandlerB response ${request.msg}")
    }

}


class Request(val msg: String, val level: Int =  Handler.LEVEL_UNKNOWN)

class Response(val msg: String)


