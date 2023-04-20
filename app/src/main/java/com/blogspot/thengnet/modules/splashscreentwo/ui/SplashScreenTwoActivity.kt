package com.blogspot.thengnet.modules.splashscreentwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySplashScreenTwoBinding
import com.blogspot.thengnet.modules.enrollmentscreenzero.ui.EnrollmentScreenZeroActivity
import com.blogspot.thengnet.modules.splashscreenone.ui.SplashScreenOneActivity
import com.blogspot.thengnet.modules.splashscreentwo.`data`.viewmodel.SplashScreenTwoVM
import kotlin.String
import kotlin.Unit

class SplashScreenTwoActivity :
    BaseActivity<ActivitySplashScreenTwoBinding>(R.layout.activity_splash_screen_two) {
  private val viewModel: SplashScreenTwoVM by viewModels<SplashScreenTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearPrevNextButto.setOnClickListener {
      val destIntent = EnrollmentScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPrevious.setOnClickListener {
      val destIntent = SplashScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SPLASH_SCREEN_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SplashScreenTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
