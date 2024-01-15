package com.blogspot.thengnet.modules.dashboardone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityDashboardOneBinding
import com.blogspot.thengnet.modules.dashboardone.data.viewmodel.DashboardOneVM
import com.blogspot.thengnet.modules.dashboardzero.ui.DashboardZeroActivity
import com.blogspot.thengnet.modules.profilezero.ui.ProfileZeroActivity

class DashboardOneActivity :
    BaseActivity<ActivityDashboardOneBinding>(R.layout.activity_dashboard_one) {
  private val viewModel: DashboardOneVM by viewModels<DashboardOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dashboardOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearMaterialYouTa2.setOnClickListener {
      val destIntent = ProfileZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearViewdetails.setOnClickListener {
      val destIntent = DashboardZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "DASHBOARD_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DashboardOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
