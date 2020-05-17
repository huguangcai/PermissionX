package com.guangcai.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.guangcai.PersmissionX
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvPermission.setOnClickListener {
            PersmissionX.request(this,Manifest.permission.CALL_PHONE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE){
                allGranted,deniedList->
                if (allGranted){
//                    Toast.makeText(this,"允许了权限",Toast.LENGTH_SHORT).show()
                    call()
                }else{
                    Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
    private fun call() {

        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data= Uri.parse("tel:10086")
        }catch (e:SecurityException){
            e.printStackTrace()
        }
    }
}
