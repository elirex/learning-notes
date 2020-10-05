package com.elirex.lifecycle.multipleactivities

import android.content.Intent
import android.os.Bundle
import com.elirex.lifecycle.BaseActivity
import com.elirex.lifecycle.R
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        button.setOnClickListener {
            startActivity(Intent(AActivity@this, BActivity::class.java))
        }
    }

}