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

class PlaceholderFragment : Fragment() {

    companion object {

        const val LIST_VIEW = "listview"

        @JvmStatic
        fun newInstance(itens: ArrayList<String>): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(LIST_VIEW, itens)
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
            val dados = it.getStringArrayList(LIST_VIEW)!!.toList()
            var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dados)
            view.findViewById<ListView>(R.id.listview).adapter = adapter
        }

        super.onViewCreated(view, savedInstanceState)
    }
}