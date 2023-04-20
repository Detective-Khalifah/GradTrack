package com.blogspot.thengnet.modules.dashboardzero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowCoursescardsBinding
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.CoursescardsRowModel
import kotlin.Int
import kotlin.collections.List

class CoursesCardsAdapter(
  var list: List<CoursescardsRowModel>
) : RecyclerView.Adapter<CoursesCardsAdapter.RowCoursescardsVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowCoursescardsVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_coursescards,parent,false)
    return RowCoursescardsVH(view)
  }

  override fun onBindViewHolder(holder: RowCoursescardsVH, position: Int) {
    val coursescardsRowModel = CoursescardsRowModel()
    // TODO uncomment following line after integration with data source
    // val coursescardsRowModel = list[position]
    holder.binding.coursescardsRowModel = coursescardsRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<CoursescardsRowModel>) {
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
      item: CoursescardsRowModel
    ) {
    }
  }

  inner class RowCoursescardsVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowCoursescardsBinding = RowCoursescardsBinding.bind(itemView)
    init {
      binding.linearHorizontalcard.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, CoursescardsRowModel())
      }
    }
  }
}
