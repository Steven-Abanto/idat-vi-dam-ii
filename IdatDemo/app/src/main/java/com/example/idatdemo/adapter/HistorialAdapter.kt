package com.example.idatdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.idatdemo.R
import com.example.idatdemo.entity.Compra

class HistorialAdapter(private val listaHistorial : List<Compra>)
    : RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {
    inner class HistorialViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ivFoto : ImageView = itemView.findViewById(R.id.ivFoto)
        val tvId : TextView = itemView.findViewById(R.id.tvId)
        val tvProducto : TextView = itemView.findViewById(R.id.tvProducto)
        val tvFecha : TextView = itemView.findViewById(R.id.tvFecha)
    }

    //Creación de plantilla - rellena valores
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historial,parent,false)
        return HistorialViewHolder(view)
    }

    //Cuántos elementos van a visualizarse
    override fun getItemCount(): Int {
        return listaHistorial.size
    }

    //Renderiza todos los elementos
    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val compra = listaHistorial[position]
        holder.tvId.text = "ID: #${compra.id}"
        holder.tvProducto.text = "Producto: #${compra.producto}"
        holder.tvFecha.text = "Fecha: #${compra.fecha}"
    }

}