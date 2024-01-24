package com.blogspot.thengnet.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R

class LocalGovernmentAreasAdapter(
    private val lgas: List<LocalGovernmentArea>,
    private val onLGASelected: (LocalGovernmentArea) -> Unit
) : RecyclerView.Adapter<LocalGovernmentAreasAdapter.LocalGovernmentAreaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalGovernmentAreaViewHolder {
        // Implement onCreateViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lga_item, parent, false)
        return LocalGovernmentAreaViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocalGovernmentAreaViewHolder, position: Int) {
        val lga = lgas[position]
        holder.bind(lga)
        holder.nameTextView.text = lga.name
        holder.itemView.setOnClickListener { onLGASelected(lga) }
    }

    override fun getItemCount(): Int = lgas.size

    class LocalGovernmentAreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Implement ViewHolder
        val nameTextView: TextView = itemView.findViewById(R.id.lga_text)
        fun bind(lga: LocalGovernmentArea) {
            // Bind data to UI components
        }
    }
}
