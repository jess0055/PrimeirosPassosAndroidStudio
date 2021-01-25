package com.example.myapplication

interface ActivityContract {
    fun onFinishForm(nome: String, email: String, telefone: String, senha: String)
}