package com.example.exerciciocamera.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exerciciocamera.R

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.exerciciocamera.PermissionsHelper
import com.example.exerciciocamera.SharedPreferencesHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var permissionsHelper: PermissionsHelper
    private val imageView by lazy { findViewById<ImageView>(R.id.imageView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferencesHelper = SharedPreferencesHelper(this)
        permissionsHelper = PermissionsHelper(this, sharedPreferencesHelper)

        initViews()
    }

    override fun onStart() {
        super.onStart()

        if (shouldAskUserToGrantPermissions()) {
            AlertDialog.Builder(this).setTitle("Alerta de uso de recursos do sistema")
                    .setMessage("Va as configuraçoes para dar as permissoes")
                    .setPositiveButton("Valeu") { dialog, _ ->
                        dialog.dismiss()
                    }.show()
        }
    }

    private fun shouldAskUserToGrantPermissions(): Boolean {
        return sharedPreferencesHelper.getShowAlertOnStartUp()
    }

    private fun initViews() {

        val btCamera = findViewById<FloatingActionButton>(R.id.btn_camera)


        btCamera.setOnClickListener {
            val permission = Manifest.permission.CAMERA
            if (requestPermission(permission)) {
                openChooser()
            }
        }

    }

    private fun openChooser() {
        val intentList = mutableListOf<Intent>()

        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

//        val pickIntent = Intent(
//            Intent.ACTION_PICK,
//            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//        )

        val pickIntent = Intent()
        pickIntent.type = "image/*"
        pickIntent.action = Intent.ACTION_GET_CONTENT

        intentList.add(pickIntent)
        intentList.add(takePhotoIntent)

        val chooserIntent = Intent.createChooser(intentList[0], "Escolha como tirar a fotografia:")
        chooserIntent.putExtra(
                Intent.EXTRA_INITIAL_INTENTS,
                intentList.toTypedArray()
        )

        startActivityForResult(chooserIntent, 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 200 && resultCode == Activity.RESULT_OK && intent?.data != null) {
            val photo = intent.data as Uri
            imageView.setImageURI(photo)
        } else if (intent?.extras != null){
            val photo = intent.extras?.get("data") as Bitmap
            imageView.setImageBitmap(photo)
        }
    }

    private fun requestPermission(permission: String) =
            permissionsHelper.requestPermission(permission)


    private fun requestAllPermission() {
        val permissions =
                listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
        permissionsHelper.requestAllPermission(permissions)
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionsHelper.handleRequestPermissionResult(
                requestCode,
                permissions,
                grantResults
        )
    }
}