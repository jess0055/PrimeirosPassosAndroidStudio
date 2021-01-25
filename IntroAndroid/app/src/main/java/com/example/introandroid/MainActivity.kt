package com.example.introandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var botaoConfirmar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoConfirmar = findViewById(R.id.confirm_button)

        //clicavel para qq view
        botaoConfirmar.setOnClickListener {
            Toast.makeText(this, "Clicou aqui", Toast.LENGTH_LONG).show()
        }
    }
}