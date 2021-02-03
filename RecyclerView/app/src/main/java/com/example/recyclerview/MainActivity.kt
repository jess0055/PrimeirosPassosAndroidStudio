package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alunos = getAlunos()

        recycler.layoutManager = LinearLayoutManager(this)

        recycler.adapter = AlunosAdapter(alunos)
    }

    private fun getAlunos(): List<Aluno> {
        val alunosList = mutableListOf<Aluno>()

        for (index in 0..30) {
            val aluno = Aluno("Aluno $index", "Matricula $index")
            alunosList.add(aluno)
        }

        return alunosList.toList()
    }
}