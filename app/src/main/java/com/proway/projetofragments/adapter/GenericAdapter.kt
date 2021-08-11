package com.proway.projetofragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.projetofragments.R
import com.proway.projetofragments.fragments.TipoLista
import com.proway.projetofragments.model.Car
import com.proway.projetofragments.model.Product

/**
 * Classe de adapter usando generics para reutilizar ela em mais locais.
 * Usamos o <T> para definir o tipo da lista que vamos passar
 *
 * @param listOf : MutableList<T> -> recebe uma lista conforme o parametro passado no <T>
 */
class GenericAdapter<T>(private val listOf: MutableList<T>, private val type: TipoLista) :
    RecyclerView.Adapter<GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val viewProduct = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        val viewCar = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        val finalView = if (type == TipoLista.PRODUTOS) viewProduct else viewCar
        return GenericViewHolder(finalView)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        listOf[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOf.size
}

class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val subTitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)

    /**
     * Usamos generics aqui tbm para identificar o conteudo que estamos recebendo para dar o
     * bind na tela.
     */
    fun <T> bind(model: T) {
        /**
         * Usamos o when e is Product e is Car para fazer o cast dos objetos.
         * Fazemos isso pq queremos acessar atributos especificos de cada classe.
         *
         */
        when (model) {
            is Product -> {
                titleTextView.text = model.id.toString()
                subTitleTextView.text = model.nome
            }
            is Car -> {
                titleTextView.text = model.modelo
                subTitleTextView.text = model.ano.toString()
            }
        }

    }

}