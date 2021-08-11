package com.proway.projetofragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.proway.projetofragments.R
import com.proway.projetofragments.model.Product

class ProductAdapter(val listOfProducts: MutableList<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOfProducts.size
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val subTitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)

    fun bind(prod: Product) {
        titleTextView.text = prod.id.toString()
        subTitleTextView.text = prod.nome
    }

}