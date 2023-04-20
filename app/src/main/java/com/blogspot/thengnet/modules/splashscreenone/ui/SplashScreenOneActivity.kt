package com.blogspot.thengnet.modules.splashscreenone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySplashScreenOneBinding
import com.blogspot.thengnet.modules.splashscreenone.`data`.viewmodel.SplashScreenOneVM
import com.blogspot.thengnet.modules.splashscreentwo.ui.SplashScreenTwoActivity
import com.blogspot.thengnet.modules.splashscreenzero.ui.SplashScreenZeroActivity
import kotlin.String
import kotlin.Unit

class SplashScreenOneActivity :
    BaseActivity<ActivitySplashScreenOneBinding>(R.layout.activity_splash_screen_one) {
  private val viewModel: SplashScreenOneVM by viewModels<SplashScreenOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPrevious.setOnClickListener {
      val destIntent = SplashScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnNext.setOnClickListener {
      val destIntent = SplashScreenTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SPLASH_SCREEN_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SplashScreenOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
