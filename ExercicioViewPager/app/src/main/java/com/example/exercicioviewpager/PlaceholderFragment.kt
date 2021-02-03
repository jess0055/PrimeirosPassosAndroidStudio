package com.example.exercicioviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class PlaceholderFragment : Fragment() {

    companion object {

        const val RECYCLE_VIEW = "recycleview"

        @JvmStatic
        fun newInstance(itens: List<ItemCardapio>): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(RECYCLE_VIEW,  itens as Serializable)
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
            rc.adapter = ItemListaAdapter(it.getSerializable(RECYCLE_VIEW) as List<ItemCardapio>)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}