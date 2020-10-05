package com.elirex.lifecycle.singleactivity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.elirex.lifecycle.R
import com.elirex.lifecycle.BaseActivity
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivityWithConfigChange : BaseActivity() {

    companion object {
        private const val REQUEST_CODE_FOR_REQUEST_PERMISSION = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
    }

    override fun onResume() {
        super.onResume()
        btnOpenDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("I'm an alert dialog.")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }.show()

        }
        btnRequestPermission.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),
                        REQUEST_CODE_FOR_REQUEST_PERMISSION
                    )
                }
            }
        }
    }

}
