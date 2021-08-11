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
import com.proway.projetofragments.adapter.GenericAdapter
import com.proway.projetofragments.model.Car
import com.proway.projetofragments.model.Product

class TerceiroFragment() : Fragment() {

    lateinit var recyclerView: RecyclerView

    var parametroTipoLista: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("tipo_lista")?.let {
            parametroTipoLista = it
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

        var listOf = mutableListOf<Any>()
        if (parametroTipoLista == TipoLista.PRODUTOS.id) {
            listOf = mutableListOf(
                Product(1, "Cerveja"),
                Product(2, "Leite"),
                Product(3, "Carne"),
                Product(4, "Fralda"),
                Product(5, "Pizza"),
                Product(6, "Água"),
            )
        } else if (parametroTipoLista == TipoLista.CARROS.id) {
            listOf = mutableListOf(
                Car("Gol", 2020),
                Car("Celta", 2020),
                Car("Marajó", 2020),
                Car("Opala", 2020),
                Car("Monza", 2020),
                Car("Onix", 2020),
                Car("Fusca", 2020),
            )
        }
        recyclerView = view.findViewById(R.id.genericRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GenericAdapter(listOf)


    }

    companion object {

        fun newInstance(tipoLista: TipoLista): TerceiroFragment {
            return TerceiroFragment().apply {
                arguments = Bundle().apply {
                    putInt("tipo_lista", tipoLista.id)
                }
            }
        }
    }
}

enum class TipoLista(val id: Int) {
    PRODUTOS(1),
    CARROS(2)
}