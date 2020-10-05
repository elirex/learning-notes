package com.elirex.lifecycle.multipleactivities

import android.os.Bundle
import com.elirex.lifecycle.BaseActivity
import com.elirex.lifecycle.R

class BActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }
}