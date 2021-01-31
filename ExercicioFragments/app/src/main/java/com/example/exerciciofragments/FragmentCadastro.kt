package com.example.exerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
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
    private val btnCadastrar by lazy {  view?.findViewById<Button>(R.id.cadastrar_botao) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnCadastrar?.setOnClickListener {
            onFinishForm()
        }
    }

    private fun onFinishForm() {
        val activityContract = requireActivity() as ActivityContract
        //requireActivity -> retorna referencia da activity q frag faz parte
        //posso fazer cast da ref para interface q ela implementa
        //tenho acesso apenas a funções do tipo q foi feito cast

        val nome = campoNome?.text.toString()
        val email = campoEmail?.text.toString()
        val tel = campoTelefone ?.text.toString()
        val senha = campoSenha?.text.toString()
        val confSenha = campoConfSenha?.text.toString()

        when {
            nome.isBlank() && email.isBlank() && tel.isBlank()&& senha.isBlank()&& confSenha.isBlank() -> {
                nomeInputLayout?.error = "Campo nome obrigatório"
                emailInputLayout?.error = "Campo email obrigatório"
                telefoneInputLayout?.error = "Campo telefone obrigatório"
                senhaInputLayout?.error = "Campo senha obrigatório"
                senhaConfInputLayout?.error = "Campo confirmar senha obrigatório"
            }
            nome.isBlank() -> {
                nomeInputLayout?.error = "Campo nome obrigatório"
                emailInputLayout?.error = null
                telefoneInputLayout?.error = null
                senhaInputLayout?.error = null
                senhaConfInputLayout?.error = null
            }
            email.isBlank() -> {
                nomeInputLayout?.error = null
                emailInputLayout?.error = "Campo email obrigatório"
                telefoneInputLayout?.error = null
                senhaInputLayout?.error = null
                senhaConfInputLayout?.error = null
            }
            tel.isBlank() -> {
                nomeInputLayout?.error = null
                emailInputLayout?.error = null
                telefoneInputLayout?.error = "Campo telefone obrigatório"
                senhaInputLayout?.error = null
                senhaConfInputLayout?.error = null
            }
            senha.isBlank() -> {
                nomeInputLayout?.error = null
                emailInputLayout?.error = null
                telefoneInputLayout?.error = null
                senhaInputLayout?.error = "Campo senha obrigatório"
                senhaConfInputLayout?.error = null
            }
            confSenha.isBlank() -> {
                nomeInputLayout?.error = null
                emailInputLayout?.error = null
                telefoneInputLayout?.error = null
                senhaInputLayout?.error = null
                senhaConfInputLayout?.error = "Campo confirmar senha obrigatório"
            }
            else -> {
                nomeInputLayout?.error = null
                emailInputLayout?.error = null
                telefoneInputLayout?.error = null
                senhaInputLayout?.error = null
                senhaConfInputLayout?.error = null


                btnCadastrar?.let { Snackbar.make(it, "Cadastro realizado com sucesso!", Snackbar.LENGTH_LONG).show() }
                activityContract.onFinishForm(nome, email, tel, senha) //chama a fun onfinishform da main activity
            }
        }
    }


}