package com.blogspot.thengnet.modules.courses0n.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityCourses0nBinding
import com.blogspot.thengnet.modules.courses0n.`data`.viewmodel.Courses0nVM
import com.blogspot.thengnet.modules.dashboardzero.ui.DashboardZeroActivity
import kotlin.String
import kotlin.Unit

class Courses0nActivity : BaseActivity<ActivityCourses0nBinding>(R.layout.activity_courses_0n) {
  private val viewModel: Courses0nVM by viewModels<Courses0nVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.courses0nVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = DashboardZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "COURSES0N_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Courses0nActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
