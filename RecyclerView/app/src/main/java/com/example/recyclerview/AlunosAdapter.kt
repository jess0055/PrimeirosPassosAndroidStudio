package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AlunosAdapter(val alunosList: MutableList<Aluno>, val alunoSelected: (Aluno, Int) -> Unit) : RecyclerView.Adapter<AlunoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aluno_item, parent, false)
        return AlunoViewHolder(view)
    }

    override fun getItemCount() = alunosList.size

    override fun onBindViewHolder(viewHolder: AlunoViewHolder, position: Int) {
        val name = viewHolder.name
        name.text = alunosList[position].nome

        val matricula = viewHolder.matricula
        matricula.text = alunosList[position].matricula

        viewHolder.itemView.setOnClickListener{
            alunoSelected(alunosList[position], position)
        }
    }

    fun addAluno() {
       // alunosList.add(0, Aluno("Aluno ${alunosList.size}", "Matrícula ${alunosList.size}")) add no topo
        alunosList.add(Aluno("Aluno ${alunosList.size}", "Matrícula ${alunosList.size}"))
        notifyDataSetChanged()
    }

}