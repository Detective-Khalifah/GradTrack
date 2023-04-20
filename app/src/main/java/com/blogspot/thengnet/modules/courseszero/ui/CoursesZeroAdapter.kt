package com.blogspot.thengnet.modules.courseszero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowCoursesZeroBinding
import com.blogspot.thengnet.modules.courseszero.`data`.model.CoursesZeroRowModel
import kotlin.Int
import kotlin.collections.List

class CoursesZeroAdapter(
  var list: List<CoursesZeroRowModel>
) : RecyclerView.Adapter<CoursesZeroAdapter.RowCoursesZeroVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowCoursesZeroVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_courses_zero,parent,false)
    return RowCoursesZeroVH(view)
  }

  override fun onBindViewHolder(holder: RowCoursesZeroVH, position: Int) {
    val coursesZeroRowModel = CoursesZeroRowModel()
    // TODO uncomment following line after integration with data source
    // val coursesZeroRowModel = list[position]
    holder.binding.coursesZeroRowModel = coursesZeroRowModel
  }

  override fun getItemCount(): Int = 10
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<CoursesZeroRowModel>) {
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
      item: CoursesZeroRowModel
    ) {
    }
  }

  inner class RowCoursesZeroVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowCoursesZeroBinding = RowCoursesZeroBinding.bind(itemView)
    init {
      binding.linearHorizontalcard.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, CoursesZeroRowModel())
      }
    }
  }
}
