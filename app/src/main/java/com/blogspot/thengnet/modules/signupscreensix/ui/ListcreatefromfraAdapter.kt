package com.blogspot.thengnet.modules.signupscreensix.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListcreatefromfra2Binding
import com.blogspot.thengnet.modules.signupscreensix.`data`.model.Listcreatefromfra2RowModel
import kotlin.Int
import kotlin.collections.List

class ListcreatefromfraAdapter(
  var list: List<Listcreatefromfra2RowModel>
) : RecyclerView.Adapter<ListcreatefromfraAdapter.RowListcreatefromfra2VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListcreatefromfra2VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listcreatefromfra2,parent,false)
    return RowListcreatefromfra2VH(view)
  }

  override fun onBindViewHolder(holder: RowListcreatefromfra2VH, position: Int) {
    val listcreatefromfra2RowModel = Listcreatefromfra2RowModel()
    // TODO uncomment following line after integration with data source
    // val listcreatefromfra2RowModel = list[position]
    holder.binding.listcreatefromfra2RowModel = listcreatefromfra2RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listcreatefromfra2RowModel>) {
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
      item: Listcreatefromfra2RowModel
    ) {
    }
  }

  inner class RowListcreatefromfra2VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListcreatefromfra2Binding = RowListcreatefromfra2Binding.bind(itemView)
  }
}
