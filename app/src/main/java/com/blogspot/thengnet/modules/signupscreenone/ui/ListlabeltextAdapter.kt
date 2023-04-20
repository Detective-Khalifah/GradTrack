package com.blogspot.thengnet.modules.signupscreenone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListlabeltext1Binding
import com.blogspot.thengnet.modules.signupscreenone.`data`.model.Listlabeltext1RowModel
import kotlin.Int
import kotlin.collections.List

class ListlabeltextAdapter(
  var list: List<Listlabeltext1RowModel>
) : RecyclerView.Adapter<ListlabeltextAdapter.RowListlabeltext1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListlabeltext1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listlabeltext1,parent,false)
    return RowListlabeltext1VH(view)
  }

  override fun onBindViewHolder(holder: RowListlabeltext1VH, position: Int) {
    val listlabeltext1RowModel = Listlabeltext1RowModel()
    // TODO uncomment following line after integration with data source
    // val listlabeltext1RowModel = list[position]
    holder.binding.listlabeltext1RowModel = listlabeltext1RowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listlabeltext1RowModel>) {
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
      item: Listlabeltext1RowModel
    ) {
    }
  }

  inner class RowListlabeltext1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListlabeltext1Binding = RowListlabeltext1Binding.bind(itemView)
  }
}
