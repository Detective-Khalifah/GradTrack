package com.blogspot.thengnet.modules.signinscreenzero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListcreatefromfra3Binding
import com.blogspot.thengnet.modules.signinscreenzero.`data`.model.Listcreatefromfra3RowModel
import kotlin.Int
import kotlin.collections.List

class ListcreatefromfraAdapter(
  var list: List<Listcreatefromfra3RowModel>
) : RecyclerView.Adapter<ListcreatefromfraAdapter.RowListcreatefromfra3VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListcreatefromfra3VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listcreatefromfra3,parent,false)
    return RowListcreatefromfra3VH(view)
  }

  override fun onBindViewHolder(holder: RowListcreatefromfra3VH, position: Int) {
    val listcreatefromfra3RowModel = Listcreatefromfra3RowModel()
    // TODO uncomment following line after integration with data source
    // val listcreatefromfra3RowModel = list[position]
    holder.binding.listcreatefromfra3RowModel = listcreatefromfra3RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listcreatefromfra3RowModel>) {
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
      item: Listcreatefromfra3RowModel
    ) {
    }
  }

  inner class RowListcreatefromfra3VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListcreatefromfra3Binding = RowListcreatefromfra3Binding.bind(itemView)
  }
}
