package com.example.googlelensclone.textrecog

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.core.content.ContextCompat.startActivity
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizerOptions

class TextAnalyzer : ImageAnalysis.Analyzer {

    val recognizer = TextRecognition.getClient()

    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        Log.d("TEXTRECOG", "image analyzed")

        imageProxy.image?.let {
            val inputImage = InputImage.fromMediaImage(it,imageProxy.imageInfo.rotationDegrees)

            recognizer.process(inputImage)
                .addOnSuccessListener { text ->
                    text.textBlocks.forEach{ block ->
                        run{

                            val term = block.lines.joinToString("/n"){it.text}


                            Log.d("TEXTRECO1",term)
//                            Intent intent = new Intent()
//                            intent = Intent.ACTION_WEB_SEARCH
//                            intent.putExtra(SearchManager.QUERY, term)
//                            startActivity(intent)

                        }
//
                    }
                }
                .addOnFailureListener { ex ->
                    Log.e("TEXTRECOG" , "Detection Failed", ex)
                }
                .addOnCompleteListener{
                    imageProxy.close()
                }
        } ?:imageProxy.close()
    }
}