package com.blogspot.thengnet.modules.profilezero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityProfileZeroBinding
import com.blogspot.thengnet.modules.profileone.ui.ProfileOneActivity
import com.blogspot.thengnet.modules.profilezero.`data`.model.ProfileZeroRowModel
import com.blogspot.thengnet.modules.profilezero.`data`.viewmodel.ProfileZeroVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfileZeroActivity : BaseActivity<ActivityProfileZeroBinding>(R.layout.activity_profile_zero)
    {
  private val viewModel: ProfileZeroVM by viewModels<ProfileZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val profileZeroAdapter =
    ProfileZeroAdapter(viewModel.profileZeroList.value?:mutableListOf())
    binding.recyclerProfileZero.adapter = profileZeroAdapter
    profileZeroAdapter.setOnItemClickListener(
    object : ProfileZeroAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ProfileZeroRowModel) {
        onClickRecyclerProfileZero(view, position, item)
      }
    }
    )
    viewModel.profileZeroList.observe(this) {
      profileZeroAdapter.updateData(it)
    }
    binding.profileZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imagePhotocamerawh.setOnClickListener {
      val destIntent = ProfileOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerProfileZero(
    view: View,
    position: Int,
    item: ProfileZeroRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PROFILE_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfileZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
