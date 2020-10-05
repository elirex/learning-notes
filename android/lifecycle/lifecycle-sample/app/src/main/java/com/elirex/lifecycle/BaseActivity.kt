package com.elirex.lifecycle

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        log("saveInstanceSate is null = ${intent == null}")
        super.onCreate(savedInstanceState)
    }

    override fun onNewIntent(intent: Intent?) {
        log("intent is null = ${intent == null}")
        super.onNewIntent(intent)
    }

    override fun onStart() {
        log()
        super.onStart()
    }

    override fun onResume() {
        log()
        super.onResume()
    }

    override fun onPause() {
        log()
        super.onPause()
    }

    override fun onStop() {
        log()
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        log()
        super.onSaveInstanceState(outState)
    }

    override fun onRestart() {
        log()
        super.onRestart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        log()
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onDestroy() {
        log()
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        log()
        super.onConfigurationChanged(newConfig)
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration?) {
        log()
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
    }

    override fun onBackPressed() {
        log()
        super.onBackPressed()
    }

    private fun log(message: String = "") {
        val previousMethodName = Thread.currentThread().stackTrace[4].methodName
        if (message.isEmpty()) {
            Log.i("Activity", "[${javaClass.simpleName}][$previousMethodName]")
        } else {
            Log.i("Activity", "[${javaClass.simpleName}][$previousMethodName] message: $message")
        }
    }

}