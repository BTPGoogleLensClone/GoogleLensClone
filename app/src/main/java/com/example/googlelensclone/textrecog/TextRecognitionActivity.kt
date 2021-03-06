package com.example.googlelensclone.textrecog

import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.googlelensclone.BaseLensActivity

class TextRecognitionActivity : BaseLensActivity() {
    override val imageAnalyzer =  TextAnalyzer()



    override fun startScanner() {
        startTextRecognition()

    }

    override fun stopScanner() {
        stopTextRecognition()
    }

    private fun startTextRecognition(){
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }

    private fun stopTextRecognition(){

        imageAnalysis.clearAnalyzer()
    }
}