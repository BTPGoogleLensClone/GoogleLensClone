package com.example.googlelensclone.BarCode

import android.annotation.SuppressLint
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

class BarcodeAnalyzer : ImageAnalysis.Analyzer {

    val scanner = BarcodeScanning.getClient()

    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        Log.d("BARCODE", "image analyzed")

        imageProxy.image?.let {
            val inputImage = InputImage.fromMediaImage(it,imageProxy.imageInfo.rotationDegrees)

            scanner.process(inputImage)
                .addOnSuccessListener { codes ->
                    codes.forEach{ barcode ->
                        Log.d("BARCODE" , """
                            Format = ${barcode.format}
                            Value = ${barcode.rawValue}
                            """.trimIndent())
                    }
                }
                .addOnFailureListener { ex ->
                    Log.e("FACEDETECT" , "Detection Failed", ex)
                }
                .addOnCompleteListener{
                    imageProxy.close()
                }
        } ?:imageProxy.close()  //close if image not found either

    }
}