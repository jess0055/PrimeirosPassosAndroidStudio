package com.example.exerciciofragments

interface ActivityContract {
    fun onFinishForm(nome: String, email: String, telefone: String, senha: String)
}