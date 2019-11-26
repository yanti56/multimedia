package com.example.camera

import android.app.Activity
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import java.security.Permission
import java.security.PermissionCollection
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // button untuk mengambil gambar dari camera
        btn_capture.setOnClickListener{
            var i = Intent (MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(i,123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
    if(requestCode == 123)
    {
        var bmp= data?. extras?. get("data") as? Bitmap
        imageView.setImageBitmap(bmp)
    }

        }
}

class MainActivity : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?)  {
    super .onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button Klik
        img_pick_btn.setOnClickListener{

            // mengecek permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if
                        (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_DENIED){
                    // peermission akses ditolak
                    val permission =
                        arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE );
                    requestPermissions(permission,
                        //PERMISSION_CODE);

                    }
                else{
                    //permission akses disetujui

                    pickImageFromGallery();
                }
            }
        }

        //Method untuk mengambil image dari gallery
        private fun pickImageFromGallery(){
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_PICK_CODE)
        }
        companion object {

            private val IMAGE_PICK_CODE = 1000;
            private val PERMISSION_CODE = 1001;
        }
        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray )
        {
     when (requestCode) {
     PERMISSION_CODE -> {
    if (grantResults.size >0 && grantResults[0])
        == PackageManager.PERMISSION_GRANTED)
     } pickImageFromGallery()
     }
            else }
        Toast.makeText(This, "permission denied",Toast.LENGTH_SHORT).show()


    }
}
}
}

override fun onActivityResult (requestCode: Int, resultCode: Int, data: Intent?) {
    if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {

        image_view.setImageURI(data?.data)
    }
    }
}