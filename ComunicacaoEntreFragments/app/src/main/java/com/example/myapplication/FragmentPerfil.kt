package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FragmentPerfil : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    fun setData(nome: String, email: String, telefone: String, senha: String) {
        view?.let {
            it.findViewById<TextView>(R.id.nome).text = nome
            it.findViewById<TextView>(R.id.email).text = email
            it.findViewById<TextView>(R.id.telefone).text = telefone
            it.findViewById<TextView>(R.id.senha).text = senha
        }
    }

}