package com.example.recycleview2020

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview2020.model.Guitarras
import kotlinx.android.synthetic.main.guitarras_row.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapter(val context:Context, val listaGuitarras:List<Guitarras>):RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        // inflamos vista
        return GitarrasViewHolder(LayoutInflater.from(context).inflate(R.layout.guitarras_row,parent,false))

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        //carga datos en lista
        if (holder is GitarrasViewHolder)
            holder.bind(listaGuitarras[position],position)
        else
            throw IllegalArgumentException("Error viewHolder erroneo")
    }

    override fun getItemCount(): Int =  listaGuitarras.size          //número de items



    inner class GitarrasViewHolder(itemView:View):BaseViewHolder<Guitarras>(itemView)// nos aseguramos de que cuando la clase padre muera, muera esta también
    {
        override fun bind(item: Guitarras, position: Int) {
            Glide.with(context).load(item.imagen).into(itemView.image)
            itemView.textView.text=item.marca+" "+item.modelo

        }
    }

}