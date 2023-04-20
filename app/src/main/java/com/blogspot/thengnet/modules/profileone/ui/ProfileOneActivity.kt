package com.blogspot.thengnet.modules.profileone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.appcomponents.views.ImagePickerFragmentDialog
import com.blogspot.thengnet.databinding.ActivityProfileOneBinding
import com.blogspot.thengnet.modules.profileone.`data`.model.ProfileOneRowModel
import com.blogspot.thengnet.modules.profileone.`data`.viewmodel.ProfileOneVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfileOneActivity : BaseActivity<ActivityProfileOneBinding>(R.layout.activity_profile_one) {
  private val viewModel: ProfileOneVM by viewModels<ProfileOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val profileOneAdapter = ProfileOneAdapter(viewModel.profileOneList.value?:mutableListOf())
    binding.recyclerProfileOne.adapter = profileOneAdapter
    profileOneAdapter.setOnItemClickListener(
    object : ProfileOneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ProfileOneRowModel) {
        onClickRecyclerProfileOne(view, position, item)
      }
    }
    )
    viewModel.profileOneList.observe(this) {
      profileOneAdapter.updateData(it)
    }
    binding.profileOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageCamera.setOnClickListener {
      ImagePickerFragmentDialog().show(supportFragmentManager)
      { path ->//TODO HANDLE DATA
      }

    }
  }

  fun onClickRecyclerProfileOne(
    view: View,
    position: Int,
    item: ProfileOneRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PROFILE_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfileOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
