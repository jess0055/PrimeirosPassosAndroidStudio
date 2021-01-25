package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class FragmentCadastro : Fragment() {

    private val campoNome by lazy {  view?.findViewById<TextInputEditText>(R.id.nome_edit_text) }
    private val campoEmail by lazy {  view?.findViewById<TextInputEditText>(R.id.email_edit_text) }
    private val campoTelefone by lazy {  view?.findViewById<TextInputEditText>(R.id.tel_edit_text) }
    private val campoSenha by lazy {  view?.findViewById<TextInputEditText>(R.id.senha_edit_text) }
    private val campoConfSenha by lazy {  view?.findViewById<TextInputEditText>(R.id.conf_senha_edit_text) }
    private val nomeInputLayout by lazy {  view?.findViewById<TextInputLayout>(R.id.nome_input_layout) }
    private val emailInputLayout by lazy {  view?.findViewById<TextInputLayout>(R.id.email_input_layout) }
    private val telefoneInputLayout by lazy {  view?.findViewById<TextInputLayout>(R.id.tel_input_layout) }
    private val senhaInputLayout by lazy {  view?.findViewById<TextInputLayout>(R.id.senha_input_layout) }
    private val senhaConfInputLayout by lazy {  view?.findViewById<TextInputLayout>(R.id.conf_senha_input_layout) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.cadastrar_botao)

        button.setOnClickListener {
            onFinishForm()
        }
    }

    private fun onFinishForm() {
        val activityContract = requireActivity() as ActivityContract

        val nome = campoNome?.text.toString()
        val email = campoEmail?.text.toString()
        val tel = campoTelefone ?.text.toString()
        val senha = campoSenha?.text.toString()

        when {
            nome.isBlank() && senha.isBlank() -> {
                nomeInputLayout?.error = "Required"
                senhaInputLayout?.error = "Required"
            }
            nome.isBlank() -> {
                nomeInputLayout?.error = "Required"
                senhaInputLayout?.error = null
            }
            senha.isBlank() -> {
                nomeInputLayout?.error = "Required"
                senhaInputLayout?.error = null
            }
            else -> {
                nomeInputLayout?.error = null
                senhaInputLayout?.error = null
                activityContract.onFinishForm(nome, email, tel, senha)
            }
        }
    }

}