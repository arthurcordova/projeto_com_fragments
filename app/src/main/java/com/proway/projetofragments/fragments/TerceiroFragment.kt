package com.proway.projetofragments.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projetofragments.R
import com.proway.projetofragments.adapter.ProductAdapter
import com.proway.projetofragments.model.Product

class TerceiroFragment() : Fragment() {

    lateinit var recyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getBoolean("chave_parametro")?.let {
//            isMyBoolean = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_terceiro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val listOf = mutableListOf<Product>(
//            Product(1, "Cerveja"),
//            Product(2, "Leite"),
//            Product(3, "Carne"),
//            Product(4, "Fralda"),
//            Product(5, "Pizza"),
//            Product(6, "Água"),
//        )
//
//        recyclerView = view.findViewById(R.id.productsRecyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = ProductAdapter(listOf)

    }

    companion object {

        fun newInstance(parametro: Boolean): TerceiroFragment {
            return TerceiroFragment().apply {
                arguments = Bundle().apply {
                    putBoolean("chave_parametro", parametro)
                }
            }
        }

    }
}