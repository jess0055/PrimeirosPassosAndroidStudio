package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initViews()
    }

    private fun initViews() {
        val textView = findViewById<TextView>(R.id.textView4)
        val btnVoltar = findViewById<Button>(R.id.button_voltar)

        val btnFloat = findViewById<FloatingActionButton>(R.id.btn_float)
        val btnFlat = findViewById<Button>(R.id.btn_flat)

        btnFlat.isEnabled

        val editText = findViewById<AppCompatEditText>(R.id.edit_text)

        btnFloat.setOnClickListener{
            val textInput = editText.text.toString()
            Log.d("input", textInput)

            if (textInput.isBlank() || textInput.length > 9){
             //   Snackbar.make(btnFloat, "texto invalido", Snackbar.LENGTH_LONG).show()

                Snackbar.make(btnFloat, "texto invalido", Snackbar.LENGTH_INDEFINITE)
                        .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                        .setAction("fechar") {
                            Toast.makeText(this, "texto invalido", Toast.LENGTH_LONG).show()
                        }
                        .show()

            }else{
                Log.d("input", textInput)
            }
        }


        val extras = intent.extras
        val text = extras?.getString("texto botão")

        textView.text = text

        btnVoltar.setOnClickListener {
            onBackPressed()
        }
    }
}
