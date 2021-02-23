package com.example.exerciciocamera

import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class PermissionsHelper(
        private val activity: Activity,
        private val sharedPreferencesHelper: SharedPreferencesHelper
) {
    fun requestPermission(permission: String): Boolean {
        val isGranted = ContextCompat.checkSelfPermission(activity, permission)

        return if (isGranted != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(permission),
                    1
            )
            false
        } else {
            Log.d(
                    PermissionsHelper::class.java.toString(),
                    "permission already granted: $permission"
            )
            true
        }
    }

    fun requestAllPermission(permissions: List<String>) {
        val permissionsNotGranted = mutableListOf<String>()

        permissions.forEach {
            if (ContextCompat.checkSelfPermission(
                            activity,
                            it
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsNotGranted.add(it)
            }
        }

        if (permissionsNotGranted.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                    activity,
                    permissionsNotGranted.toTypedArray(),
                    2
            )
        } else {
            Log.d(PermissionsHelper::class.java.toString(), "all permission granted")
        }
    }

    fun handleRequestPermissionResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        if (permissions.isEmpty()) return

        when (requestCode) {
            1 -> {
                if (shouldAskRationale(permissions[0])) {
                    android.app.AlertDialog.Builder(activity).setTitle("Alerta de permissao importante")
                            .setMessage("Porque utiliza a permissao")
                            .setPositiveButton("OK") { _, _ ->
                                requestPermission(permissions[0])
                            }.setNegativeButton("No") { dialog, _ ->
                                dialog.dismiss()
                            }.show()

                } else {
                    if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                        sharedPreferencesHelper.putShowAlertOnStartUp(true)
                    }
                }
            }
            else -> {

            }
        }
    }

    private fun shouldAskRationale(permission: String) =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                    activity.shouldShowRequestPermissionRationale(permission)
}