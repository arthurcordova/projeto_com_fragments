package com.proway.projetofragments.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projetofragments.R
import com.proway.projetofragments.adapter.GenericAdapter
import com.proway.projetofragments.model.Car
import com.proway.projetofragments.model.Product

class TerceiroFragment() : Fragment() {

    lateinit var recyclerView: RecyclerView

    var parametroTipoLista: Int = 0

    /**
     * Buscamos pelo parametro que foi enviado pelo newInstance()
     *
     * onAttach é o primeiro método chamado automaticamente pelo Fragment
     *
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("tipo_lista")?.let {
            parametroTipoLista = it
        }
    }

    /**
     * Vincula o Fragment com um layout xml.
     * Obrigatorio implementar este método para ter uma view
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_terceiro, container, false)
    }

    /**
     * Método executado pelo fragment após ter criado a view
     *
     * @param view View -> Usamos a view que recebemos por parametro para
     * manipular os componentes que add no xml.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Criamos a lista desta maneira pq usamos generics.
         * Declaramos ela como Any, mas na sequencia modificamos a instance dela
         * pela lista que gostariamos.
         */
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
                Car("Gol", 2020, "Gasolina"),
                Car("Celta", 2020, "Diesel"),
                Car("Marajó", 2020, "Eletrico"),
                Car("Opala", 2020, "Gasolina"),
                Car("Monza", 2020, "Gasolina"),
                Car("Onix", 2020, "Diesel"),
                Car("Fusca", 2020, "Gasolina"),
            )
        }
        recyclerView = view.findViewById(R.id.genericRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        /**
         * No construtor do Adapter recebemos um MutableList<T>.
         * Então podemos enviar uma de qualquer objeto para ele, claro que
         * neste caso tratamos somente para as classes Car e Product.
         */
        recyclerView.adapter = GenericAdapter(
            listOf,
            if (parametroTipoLista == TipoLista.PRODUTOS.id) TipoLista.PRODUTOS else TipoLista.CARROS
        )
    }

    companion object {

        /**
         * Criado esta funçao para retornar uma instancia do TerceiroFragment.
         * Fazemos isso pq é uma boa pratica deixa o Fragment com um construtor
         * limpo. OBS-> Criamos dentor do companion para deixar static
         *
         * @param tipoLista TipoLista - Parametro que irá definir a exibição de lista CARROS/PRODUTOS
         *
         */
        fun newInstance(tipoLista: TipoLista): TerceiroFragment {
            return TerceiroFragment().apply {
                /**
                 * Buscamos os arguments do Fragment e add o tipo da lista por parametro
                 */
                arguments = Bundle().apply {
                    putInt("tipo_lista", tipoLista.id)
                }
            }
        }
    }
}

/**
 * Enum criado para identificar o tipo da lista CARRO/PRODUTO
 */
enum class TipoLista(val id: Int) {
    PRODUTOS(1),
    CARROS(2)
}