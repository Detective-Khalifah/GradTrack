package com.blogspot.thengnet.modules.dashboardzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityDashboardZeroBinding
import com.blogspot.thengnet.modules.dashboardone.ui.DashboardOneActivity
import com.blogspot.thengnet.modules.dashboardzero.data.viewmodel.DashboardZeroVM
import com.blogspot.thengnet.modules.profilezero.ui.ProfileZeroActivity

class DashboardZeroActivity :
    BaseActivity<ActivityDashboardZeroBinding>(R.layout.activity_dashboard_zero) {
  private val viewModel: DashboardZeroVM by viewModels<DashboardZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dashboardZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearMaterialYouTa2.setOnClickListener {
      val destIntent = ProfileZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearViewdetails.setOnClickListener {
      val destIntent = DashboardOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "DASHBOARD_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DashboardZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
