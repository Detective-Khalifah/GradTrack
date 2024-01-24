package com.blogspot.thengnet.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R

class StatesAdapter(
    private val states: List<State>,
    private val onStateSelected: (State) -> Unit
) : RecyclerView.Adapter<StatesAdapter.StatesViewHolder>(), Filterable {

    private var filteredStates: List<State> = states

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatesViewHolder {
        // Implement onCreateViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.state_item, parent, false)
        return StatesViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatesViewHolder, position: Int) {
        val state = states[position]
        holder.stateText.text = state.name
    }

    override fun getItemCount() = states.size

    class StatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Implement ViewHolder
        val stateText: TextView = itemView.findViewById(R.id.state_text)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredResults = if (constraint.isNullOrEmpty()) {
                    states
                } else {
                    states.filter { state ->
                        state.name.contains(constraint, true)
                    }
                }

                val results = FilterResults()
                results.values = filteredResults
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredStates = results?.values as List<State>
                notifyDataSetChanged()
            }
        }
    }

}

class LGAsAdapter(private val lgas: List<LocalGovernmentArea>) :
    RecyclerView.Adapter<LGAsAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.lga_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lga_state, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lga = lgas[position]
        holder.nameTextView.text = lga.name
    }

    override fun getItemCount() = lgas.size
}