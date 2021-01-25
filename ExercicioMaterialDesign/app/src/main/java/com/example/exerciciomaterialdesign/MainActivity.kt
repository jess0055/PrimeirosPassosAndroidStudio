package com.example.exerciciomaterialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val btn = findViewById<FloatingActionButton>(R.id.btn_float)

        btn.setOnClickListener {
           // Snackbar.make(btn, "Here's a Snackbar", Snackbar.LENGTH_LONG).show()
            Snackbar.make(btn, "Here's a Snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                .setAction("ACTION") {
                    Toast.makeText(this, "lalala", Toast.LENGTH_LONG).show()
                }
                .show()
        }
    }
}