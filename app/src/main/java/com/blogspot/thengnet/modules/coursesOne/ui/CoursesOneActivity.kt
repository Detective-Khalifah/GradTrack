package com.blogspot.thengnet.modules.coursesOne.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityCoursesOneBinding
import com.blogspot.thengnet.modules.coursesOne.data.viewmodel.CoursesOneVM
import com.blogspot.thengnet.modules.dashboardzero.ui.DashboardZeroActivity

class CoursesOneActivity : BaseActivity<ActivityCoursesOneBinding>(R.layout.activity_courses_one) {
  private val viewModel: CoursesOneVM by viewModels<CoursesOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.coursesOneVM = viewModel
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
      val destIntent = Intent(context, CoursesOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
