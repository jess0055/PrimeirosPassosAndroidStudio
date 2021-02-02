package com.example.exercicioviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListaAdapter(val itensList: List<ItemCardapio>) : RecyclerView.Adapter<ItemListaAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListaAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)
        return ItemViewHolder(view)
    }


    override fun getItemCount() = itensList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.descricao.text = itensList[position].descricao
        holder.valor.text = itensList[position].valor
    }


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val descricao by lazy { view.findViewById<TextView>(R.id.tv_item) }
        val valor by lazy { view.findViewById<TextView>(R.id.tv_valor) }
    }
}