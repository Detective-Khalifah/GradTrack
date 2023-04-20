package com.blogspot.thengnet.modules.dashboardone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListinitial1Binding
import com.blogspot.thengnet.modules.dashboardone.`data`.model.Listinitial1RowModel
import kotlin.Int
import kotlin.collections.List

class ListinitialAdapter(
  var list: List<Listinitial1RowModel>
) : RecyclerView.Adapter<ListinitialAdapter.RowListinitial1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListinitial1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listinitial1,parent,false)
    return RowListinitial1VH(view)
  }

  override fun onBindViewHolder(holder: RowListinitial1VH, position: Int) {
    val listinitial1RowModel = Listinitial1RowModel()
    // TODO uncomment following line after integration with data source
    // val listinitial1RowModel = list[position]
    holder.binding.listinitial1RowModel = listinitial1RowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listinitial1RowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: Listinitial1RowModel
    ) {
    }
  }

  inner class RowListinitial1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListinitial1Binding = RowListinitial1Binding.bind(itemView)
  }
}
