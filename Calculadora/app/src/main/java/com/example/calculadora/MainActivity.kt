package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.*
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val primeiroNumEdit by lazy { findViewById<TextInputEditText>(R.id.primeiro_num) }
    private val segundoNumEdit by lazy { findViewById<TextInputEditText>(R.id.segundo_num) }
    private val primeiroNumLayout by lazy { findViewById<TextInputLayout>(R.id.primeiro_num_layout) }
    private val segundoNumLayout by lazy { findViewById<TextInputLayout>(R.id.segundo_num_layout) }
    private val btnCalcular by lazy { findViewById<Button>(R.id.btn_calcular) }
    private val textResultado by lazy { findViewById<TextView>(R.id.text_resultado) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            validarForm()
        }
    }

    fun validarForm() {
        val n1 = primeiroNumEdit?.text.toString()
        val n2 = segundoNumEdit?.text.toString()

        when {
            n1.isBlank() && n2.isBlank()-> {
                primeiroNumLayout?.error = "Required"
                segundoNumLayout?.error = "Required"
            }
            n1.isBlank() -> {
                primeiroNumLayout?.error = "Required"
                segundoNumLayout?.error = null
            }
            n2.isBlank()-> {
                primeiroNumLayout?.error = null
                segundoNumLayout?.error = "Required"
            }
            else -> {
                primeiroNumLayout?.error = null
                segundoNumLayout?.error = null

                textResultado.text = somar(
                    primeiroNumEdit.text.toString().toInt(),
                    segundoNumEdit.text.toString().toInt()
                ).toString()
            }
            }

        }

    fun somar (n1: Int, n2: Int) : Int = n1 + n2
}
