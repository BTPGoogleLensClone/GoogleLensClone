package com.example.googlelensclone.BarCode

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.camera.core.*
import androidx.core.content.ContextCompat
import com.example.googlelensclone.BaseLensActivity
import com.example.googlelensclone.R
import kotlinx.android.synthetic.main.activity_lens.*
import kotlinx.android.synthetic.main.activity_camera.*

class BarCodeActivity : BaseLensActivity() {

    override val imageAnalyzer =  BarcodeAnalyzer()

    override fun startScanner() {
        scanBarcode()

    }

    override fun stopScanner() {
        Log.d("Hello","H")
    }

    private fun scanBarcode() {

        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }


}