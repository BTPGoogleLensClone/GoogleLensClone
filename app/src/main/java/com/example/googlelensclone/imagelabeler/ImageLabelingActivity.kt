package com.example.googlelensclone.imagelabeler

import android.util.Log
import androidx.core.content.ContextCompat
import com.example.googlelensclone.BaseLensActivity
import com.example.googlelensclone.imagelabeler.ImageLabelAnalyzer

class ImageLabelingActivity : BaseLensActivity() {

    override val imageAnalyzer = ImageLabelAnalyzer()

    override fun startScanner() {
        startImageLabeling()
    }

    override fun stopScanner() {
        Log.d("Hello","H")
    }

    private fun startImageLabeling() {
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }
}