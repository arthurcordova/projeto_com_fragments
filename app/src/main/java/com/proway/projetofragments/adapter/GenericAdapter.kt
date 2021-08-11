package com.proway.projetofragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.projetofragments.R
import com.proway.projetofragments.model.Car
import com.proway.projetofragments.model.Product

class GenericAdapter<T>(private val listOf: MutableList<T>) :
    RecyclerView.Adapter<GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return GenericViewHolder(view)
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

    fun <T> bind(model: T) {
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