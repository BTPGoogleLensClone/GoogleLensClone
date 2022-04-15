package com.example.googlelensclone
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.googlelensclone.BarCode.BarCodeActivity
import com.example.googlelensclone.facedetect.FaceDetectActivity
import com.example.googlelensclone.imagelabeler.ImageLabelingActivity
import com.example.googlelensclone.textrecog.TextRecognitionActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    companion object {
        @JvmStatic  val PHOTO_REQ_CODE = 234
        @JvmStatic val EXTRA_DATA ="data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTakeExtPhoto.setOnClickListener {
            val takePhototIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePhototIntent , PHOTO_REQ_CODE)
        }

        btnCameraActivity.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        btnBarcodeActivity.setOnClickListener{
            startActivity(Intent(this, BarCodeActivity::class.java))
        }

        btnFaceDetectActivity.setOnClickListener{
            startActivity(Intent(this,FaceDetectActivity::class.java))
        }
        btnLabelerActivity.setOnClickListener{
            startActivity(Intent(this,ImageLabelingActivity::class.java))
        }
        btnTextRecogActivity.setOnClickListener{
            startActivity(Intent(this,TextRecognitionActivity::class.java))
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == PHOTO_REQ_CODE) {
            val bitmap = data?.extras?.get(EXTRA_DATA) as Bitmap
            imgThumb.setImageBitmap(bitmap)
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}