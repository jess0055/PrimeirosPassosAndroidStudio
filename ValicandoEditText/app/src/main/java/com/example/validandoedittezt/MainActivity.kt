package com.example.validandoedittezt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val floatButton by lazy { findViewById<FloatingActionButton>(R.id.btn_check) }
    private val editName by lazy { findViewById<TextInputEditText>(R.id.edit_nome) }
    private val editEmail by lazy { findViewById<TextInputEditText>(R.id.edit_email) }
    private val layoutName by lazy { findViewById<TextInputLayout>(R.id.text_layout_nome) }
    private val layoutEmail by lazy { findViewById<TextInputLayout>(R.id.text_layout_email) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatButton.setOnClickListener{
         //"Chamar o metodo validateLogin e passar os itens que o usuario escreveu")
            val nome = editName?.text.toString()
            val email = editEmail?.text.toString()
            validateLogin(nome, email)
        }
    }

    fun validateLogin(nome: String, email: String) {
    //"Validar nome e email estão corretos, se forem corretos subir um SnackBar dizendo 'Sucesso'")
        when {
            nome.isBlank() && email.isBlank()-> {
                layoutName?.error = "Required"
                layoutEmail?.error = "Required"
            }
            nome.isBlank() -> {
                layoutName?.error = "Required"
                layoutEmail?.error = null
            }
            email.isBlank()-> {
                layoutName?.error = null
                layoutEmail?.error = "Required"
            }
            else -> {
                layoutName?.error = null
                layoutEmail?.error = null
                Snackbar.make(floatButton, "Sucesso", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}