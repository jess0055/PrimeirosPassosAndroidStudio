package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        Log.d("ciclo", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ciclo", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ciclo", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ciclo", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ciclo", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ciclo", "onRestart")
    }

    private fun initViews() {
        val btn = findViewById<Button>(R.id.button_activity)

        btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("texto botão", "texto intent")
            startActivity(intent)
        }

    }
}