package com.blogspot.thengnet.modules.dashboardzero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListinitialBinding
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.ListinitialRowModel
import kotlin.Int
import kotlin.collections.List

class ListinitialAdapter(
  var list: List<ListinitialRowModel>
) : RecyclerView.Adapter<ListinitialAdapter.RowListinitialVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListinitialVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listinitial,parent,false)
    return RowListinitialVH(view)
  }

  override fun onBindViewHolder(holder: RowListinitialVH, position: Int) {
    val listinitialRowModel = ListinitialRowModel()
    // TODO uncomment following line after integration with data source
    // val listinitialRowModel = list[position]
    holder.binding.listinitialRowModel = listinitialRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListinitialRowModel>) {
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
      item: ListinitialRowModel
    ) {
    }
  }

  inner class RowListinitialVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListinitialBinding = RowListinitialBinding.bind(itemView)
    init {
      binding.linearHorizontalcard.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ListinitialRowModel())
      }
    }
  }
}
