package com.blogspot.thengnet.modules.dashboardone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowCoursescards1Binding
import com.blogspot.thengnet.modules.dashboardone.`data`.model.Coursescards1RowModel
import kotlin.Int
import kotlin.collections.List

class CoursesCardsAdapter(
  var list: List<Coursescards1RowModel>
) : RecyclerView.Adapter<CoursesCardsAdapter.RowCoursescards1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowCoursescards1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_coursescards1,parent,false)
    return RowCoursescards1VH(view)
  }

  override fun onBindViewHolder(holder: RowCoursescards1VH, position: Int) {
    val coursescards1RowModel = Coursescards1RowModel()
    // TODO uncomment following line after integration with data source
    // val coursescards1RowModel = list[position]
    holder.binding.coursescards1RowModel = coursescards1RowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Coursescards1RowModel>) {
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
      item: Coursescards1RowModel
    ) {
    }
  }

  inner class RowCoursescards1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowCoursescards1Binding = RowCoursescards1Binding.bind(itemView)
  }
}
