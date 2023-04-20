package com.blogspot.thengnet.modules.signupscreentwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListlabeltext2Binding
import com.blogspot.thengnet.modules.signupscreentwo.`data`.model.Listlabeltext2RowModel
import kotlin.Int
import kotlin.collections.List

class ListlabeltextAdapter(
  var list: List<Listlabeltext2RowModel>
) : RecyclerView.Adapter<ListlabeltextAdapter.RowListlabeltext2VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListlabeltext2VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listlabeltext2,parent,false)
    return RowListlabeltext2VH(view)
  }

  override fun onBindViewHolder(holder: RowListlabeltext2VH, position: Int) {
    val listlabeltext2RowModel = Listlabeltext2RowModel()
    // TODO uncomment following line after integration with data source
    // val listlabeltext2RowModel = list[position]
    holder.binding.listlabeltext2RowModel = listlabeltext2RowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listlabeltext2RowModel>) {
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
      item: Listlabeltext2RowModel
    ) {
    }
  }

  inner class RowListlabeltext2VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListlabeltext2Binding = RowListlabeltext2Binding.bind(itemView)
  }
}
