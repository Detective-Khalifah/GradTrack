package com.blogspot.thengnet.data

import android.content.Context
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
    private val stateList: List<State>
) : ArrayAdapter<State>(context, layoutResId, stateList) {

//    class StateAdapter(
//        context: Context,
//        private val stateList: List<State>
//    ) : ArrayAdapter<State>(context, R.layout.state_item, R.id.state_text, stateList) {


    val TAG = StateAdapter::class.java.name

    override fun getCount(): Int {
        return stateList.size
    }

    override fun getItem(position: Int): State {
        return stateList[position]
//        return stateList.getOrNull(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val state = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.state_item, parent, false)

        // Bind data to UI components
        val stateText: TextView = view.findViewById(R.id.state_text)
        stateText.text = state.name
        return view

        /**
        // Customize how the selected item appears in the AutoCompleteTextView
        val view = super.getView(position, convertView, parent)
        // Customize the appearance of the selected item (if needed)
//        view.findViewById<AutoCompleteTextView>(R.id.state_of_origin_auto)
        view.findViewById<TextView>(R.id.state_text)
        Log.d(TAG,"getView: $position")
        return view
        */
    }



    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val state = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.state_item, parent, false)

        // Bind data to UI components
        val stateText: TextView = view.findViewById(R.id.state_text)
        stateText.text = state.name
        return view
        /**
        // Customize how each dropdown item appears
        val view = super.getDropDownView(position, convertView, parent)
        // Customize the appearance of each dropdown item (if needed)
//        view.findViewById<AutoCompleteTextView>(R.id.state_of_origin_auto)
        view.findViewById<TextView>(R.id.state_text)
        Log.d(TAG, "getDropDownView: $position")
        return view
        */
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                filterResults.values = stateList
                filterResults.count = stateList.size
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                notifyDataSetChanged()
            }
        }
    }
}
