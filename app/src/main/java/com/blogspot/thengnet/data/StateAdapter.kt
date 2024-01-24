package com.blogspot.thengnet.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.blogspot.thengnet.R

class StateAdapter(
    context: Context,
    @LayoutRes private val layoutResId: Int,
    private val stateList: List<State>,
    private val onStateSelected: (State) -> Unit
) : ArrayAdapter<State>(context, layoutResId, stateList) {

    private var filteredStates: List<State> = stateList

    val LOG_TAG = StateAdapter::class.java.name

    override fun getCount(): Int {
        return filteredStates.size
    }

    override fun getItem(position: Int): State {
        return filteredStates[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.state_item, parent, false)

        // Bind data to UI components
        val stateText: TextView = view.findViewById(R.id.state_text)
        val state = getItem(position)
        stateText.text = state.name
        Log.d(LOG_TAG, "getView at $position: $state")
        return view
    }


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
        val state = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.state_item, parent, false)

        // Bind data to UI components
        val stateText: TextView = view.findViewById(R.id.state_text)
        stateText.text = state.name
        Log.d(LOG_TAG, "dropDownView at $position: $state")
        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            /** This method is called in a background thread to perform the actual filtering
             * operation. It takes the user input
             * @param constraint and
             * @return FilterResults object that contains the filtered data.
             */
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredResults = stateList.filter { state ->
                    Log.v(LOG_TAG, "filter: $state")
                    state.name.contains(constraint ?: "", true)
                }

                val results = FilterResults()
                results.values = filteredResults
                return results
            }

            /**
             *  This method is called in the UI thread with the results obtained from
             *  performFiltering. It updates the UI with the filtered data and notifies the adapter
             *  that the underlying data has changed.
             */
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredStates = results?.values as List<State>
                Log.v(LOG_TAG, "filteredStates: $filteredStates")
                notifyDataSetChanged()
            }
        }
    }
}
