package com.calypsobronte.appcamera

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnView.setOnClickListener{
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager)!=null)
            {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }
        }//FIN DE btnView
    }//FIN DE onCreate

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            CAMERA_REQUEST_CODE->{
                if(resultCode==Activity.RESULT_OK && data !=null){
                    photoImageView.setImageBitmap(data.extras.get("data") as Bitmap)
                }
            }

            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT).show()
            }
        }
    }

}//FIN DE MainActivity