package com.blogspot.thengnet.modules.signupscreenzero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowListlabeltextBinding
import com.blogspot.thengnet.modules.signupscreenzero.`data`.model.ListlabeltextRowModel
import kotlin.Int
import kotlin.collections.List

class ListlabeltextAdapter(
  var list: List<ListlabeltextRowModel>
) : RecyclerView.Adapter<ListlabeltextAdapter.RowListlabeltextVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListlabeltextVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listlabeltext,parent,false)
    return RowListlabeltextVH(view)
  }

  override fun onBindViewHolder(holder: RowListlabeltextVH, position: Int) {
    val listlabeltextRowModel = ListlabeltextRowModel()
    // TODO uncomment following line after integration with data source
    // val listlabeltextRowModel = list[position]
    holder.binding.listlabeltextRowModel = listlabeltextRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListlabeltextRowModel>) {
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
      item: ListlabeltextRowModel
    ) {
    }
  }

  inner class RowListlabeltextVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListlabeltextBinding = RowListlabeltextBinding.bind(itemView)
  }
}
