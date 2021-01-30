package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity(), ActivityContract {
    lateinit var fragmentProfile: FragmentPerfil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onFinishForm(nome: String, email: String, telefone: String, senha: String) {
        fragmentProfile = supportFragmentManager.findFragmentById(R.id.fragment_perfil) as FragmentPerfil
        fragmentProfile.setData(nome, email, telefone, senha)
       // hideKeyboard()
    }

//    private fun hideKeyboard() {
//        val inputService = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        inputService.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
//    }

}