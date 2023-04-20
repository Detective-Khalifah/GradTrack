package com.blogspot.thengnet.modules.signupscreenfive.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListcreatefromfra1Binding
import com.blogspot.thengnet.modules.signupscreenfive.`data`.model.Listcreatefromfra1RowModel
import kotlin.Int
import kotlin.collections.List

class ListcreatefromfraAdapter(
  var list: List<Listcreatefromfra1RowModel>
) : RecyclerView.Adapter<ListcreatefromfraAdapter.RowListcreatefromfra1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListcreatefromfra1VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listcreatefromfra1,parent,false)
    return RowListcreatefromfra1VH(view)
  }

  override fun onBindViewHolder(holder: RowListcreatefromfra1VH, position: Int) {
    val listcreatefromfra1RowModel = Listcreatefromfra1RowModel()
    // TODO uncomment following line after integration with data source
    // val listcreatefromfra1RowModel = list[position]
    holder.binding.listcreatefromfra1RowModel = listcreatefromfra1RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listcreatefromfra1RowModel>) {
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
      item: Listcreatefromfra1RowModel
    ) {
    }
  }

  inner class RowListcreatefromfra1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListcreatefromfra1Binding = RowListcreatefromfra1Binding.bind(itemView)
  }
}
