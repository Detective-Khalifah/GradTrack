package com.blogspot.thengnet.modules.forgotpasswordtwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListcreatefromfra4Binding
import com.blogspot.thengnet.modules.forgotpasswordtwo.`data`.model.Listcreatefromfra4RowModel
import kotlin.Int
import kotlin.collections.List

class ListcreatefromfraAdapter(
  var list: List<Listcreatefromfra4RowModel>
) : RecyclerView.Adapter<ListcreatefromfraAdapter.RowListcreatefromfra4VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListcreatefromfra4VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listcreatefromfra4,parent,false)
    return RowListcreatefromfra4VH(view)
  }

  override fun onBindViewHolder(holder: RowListcreatefromfra4VH, position: Int) {
    val listcreatefromfra4RowModel = Listcreatefromfra4RowModel()
    // TODO uncomment following line after integration with data source
    // val listcreatefromfra4RowModel = list[position]
    holder.binding.listcreatefromfra4RowModel = listcreatefromfra4RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listcreatefromfra4RowModel>) {
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
      item: Listcreatefromfra4RowModel
    ) {
    }
  }

  inner class RowListcreatefromfra4VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListcreatefromfra4Binding = RowListcreatefromfra4Binding.bind(itemView)
  }
}
