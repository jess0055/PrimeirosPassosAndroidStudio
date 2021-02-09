package com.example.settingssharedprefs

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    companion object{
        const val USER_PREFS = "USER_PREFS"
        const val SHOW_NOTIFICATIONS = "show_notifications"
        const val SHOW_DOWNLOADS = "show_downloads"
        const val SHOW_WIFI = "show_wifi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configViews(configSharedPrefs())
    }

    private fun configViews(prefs: SharedPreferences) {
        val notSwitch = findViewById<SwitchCompat>(R.id.sw_notifications)
        val downloadSwitch = findViewById<SwitchCompat>(R.id.sw_downloads)
        val wifiSwitch = findViewById<SwitchCompat>(R.id.sw_wifi)


        notSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_NOTIFICATIONS, isChecked).apply()
        }

        downloadSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_DOWNLOADS, isChecked).apply()
        }

        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_WIFI, isChecked).apply()
        }


        notSwitch.isChecked  = prefs.getBoolean(SHOW_NOTIFICATIONS, true)
        downloadSwitch.isChecked = prefs.getBoolean(SHOW_DOWNLOADS, true)
        wifiSwitch.isChecked =  prefs.getBoolean(SHOW_WIFI, true)

    }

    private fun configSharedPrefs() = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
}