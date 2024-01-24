package com.blogspot.thengnet.data

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LocalGovernmentAreasAdapter(
    private val lgas: List<LocalGovernmentArea>,
    private val onLGASelected: (LocalGovernmentArea) -> Unit
) : RecyclerView.Adapter<LocalGovernmentAreasAdapter.LocalGovernmentAreaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalGovernmentAreaViewHolder {
        // Implement onCreateViewHolder
        return TODO("Provide the return value")
    }

    override fun onBindViewHolder(holder: LocalGovernmentAreaViewHolder, position: Int) {
        val lga = lgas[position]
        holder.bind(lga)
        holder.itemView.setOnClickListener { onLGASelected(lga) }
    }

    override fun getItemCount(): Int = lgas.size

    class LocalGovernmentAreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Implement ViewHolder
        fun bind(lga: LocalGovernmentArea) {
            // Bind data to UI components
        }
    }
}
