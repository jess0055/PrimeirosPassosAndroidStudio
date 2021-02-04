package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    val button by lazy { findViewById<Button>(R.id.bt_add_alunos) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alunos = getAlunos()

        recycler.layoutManager = LinearLayoutManager(this)

       val adapter = AlunosAdapter(alunos)
        { aluno, position ->
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("dados aluno click", "$aluno, position = $position")
            startActivity(intent)
        }
        recycler.adapter = adapter

        button.setOnClickListener {
            adapter.addAluno()
        }
    }

    private fun getAlunos(): MutableList<Aluno> {
        val alunosList = mutableListOf<Aluno>()

        for (index in 0..30) {
            val aluno = Aluno("Aluno $index", "Matricula $index")
            alunosList.add(aluno)
        }

        return alunosList
    }
}