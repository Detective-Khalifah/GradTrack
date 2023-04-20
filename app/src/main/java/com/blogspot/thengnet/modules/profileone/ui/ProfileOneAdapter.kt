package com.blogspot.thengnet.modules.profileone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowProfileOneBinding
import com.blogspot.thengnet.modules.profileone.`data`.model.ProfileOneRowModel
import kotlin.Int
import kotlin.collections.List

class ProfileOneAdapter(
  var list: List<ProfileOneRowModel>
) : RecyclerView.Adapter<ProfileOneAdapter.RowProfileOneVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProfileOneVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_profile_one,parent,false)
    return RowProfileOneVH(view)
  }

  override fun onBindViewHolder(holder: RowProfileOneVH, position: Int) {
    val profileOneRowModel = ProfileOneRowModel()
    // TODO uncomment following line after integration with data source
    // val profileOneRowModel = list[position]
    holder.binding.profileOneRowModel = profileOneRowModel
  }

  override fun getItemCount(): Int = 9
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ProfileOneRowModel>) {
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
      item: ProfileOneRowModel
    ) {
    }
  }

  inner class RowProfileOneVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowProfileOneBinding = RowProfileOneBinding.bind(itemView)
  }
}
