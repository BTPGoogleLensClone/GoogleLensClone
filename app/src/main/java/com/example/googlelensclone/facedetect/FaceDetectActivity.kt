package com.example.googlelensclone.facedetect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.googlelensclone.BaseLensActivity

class FaceDetectActivity : BaseLensActivity() {

    override val imageAnalyzer = FaceDetectAnalyzer()

    override fun startScanner() {
        startFaceDetect()
    }

    override fun stopScanner() {
        Log.d("Hello","H")
    }

    private fun startFaceDetect(){
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}