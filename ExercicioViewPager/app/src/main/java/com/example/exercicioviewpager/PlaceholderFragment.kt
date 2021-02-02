package com.example.exercicioviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlaceholderFragment : Fragment() {

    companion object {

        const val RECYCLE_VIEW = "recycleview"

        @JvmStatic
        fun newInstance(itens: List<ItemCardapio>): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                  //  putSerializable(RECYCLE_VIEW, itens)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        arguments?.let {
           val rc = view.findViewById<RecyclerView>(R.id.recycler_view)
            rc.layoutManager = LinearLayoutManager(requireContext())
           // rc.adapter = ItemListaAdapter(it.getSerializable(RECYCLE_VIEW))
        }

        super.onViewCreated(view, savedInstanceState)
    }
}