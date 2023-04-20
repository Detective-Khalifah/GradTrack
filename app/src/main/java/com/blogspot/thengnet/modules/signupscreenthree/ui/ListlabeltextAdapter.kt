package com.blogspot.thengnet.modules.signupscreenthree.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListlabeltext3Binding
import com.blogspot.thengnet.modules.signupscreenthree.`data`.model.Listlabeltext3RowModel
import kotlin.Int
import kotlin.collections.List

class ListlabeltextAdapter(
  var list: List<Listlabeltext3RowModel>
) : RecyclerView.Adapter<ListlabeltextAdapter.RowListlabeltext3VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListlabeltext3VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listlabeltext3,parent,false)
    return RowListlabeltext3VH(view)
  }

  override fun onBindViewHolder(holder: RowListlabeltext3VH, position: Int) {
    val listlabeltext3RowModel = Listlabeltext3RowModel()
    // TODO uncomment following line after integration with data source
    // val listlabeltext3RowModel = list[position]
    holder.binding.listlabeltext3RowModel = listlabeltext3RowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listlabeltext3RowModel>) {
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
      item: Listlabeltext3RowModel
    ) {
    }
  }

  inner class RowListlabeltext3VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListlabeltext3Binding = RowListlabeltext3Binding.bind(itemView)
  }
}
