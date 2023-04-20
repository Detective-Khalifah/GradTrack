package com.blogspot.thengnet.modules.profilezero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.thengnet.R
import com.blogspot.thengnet.databinding.RowProfileZeroBinding
import com.blogspot.thengnet.modules.profilezero.`data`.model.ProfileZeroRowModel
import kotlin.Int
import kotlin.collections.List

class ProfileZeroAdapter(
  var list: List<ProfileZeroRowModel>
) : RecyclerView.Adapter<ProfileZeroAdapter.RowProfileZeroVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProfileZeroVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_profile_zero,parent,false)
    return RowProfileZeroVH(view)
  }

  override fun onBindViewHolder(holder: RowProfileZeroVH, position: Int) {
    val profileZeroRowModel = ProfileZeroRowModel()
    // TODO uncomment following line after integration with data source
    // val profileZeroRowModel = list[position]
    holder.binding.profileZeroRowModel = profileZeroRowModel
  }

  override fun getItemCount(): Int = 9
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ProfileZeroRowModel>) {
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
      item: ProfileZeroRowModel
    ) {
    }
  }

  inner class RowProfileZeroVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowProfileZeroBinding = RowProfileZeroBinding.bind(itemView)
  }
}
