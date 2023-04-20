package com.blogspot.thengnet.modules.splashscreenzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySplashScreenZeroBinding
import com.blogspot.thengnet.modules.splashscreenone.ui.SplashScreenOneActivity
import com.blogspot.thengnet.modules.splashscreenzero.`data`.viewmodel.SplashScreenZeroVM
import kotlin.String
import kotlin.Unit

class SplashScreenZeroActivity :
    BaseActivity<ActivitySplashScreenZeroBinding>(R.layout.activity_splash_screen_zero) {
  private val viewModel: SplashScreenZeroVM by viewModels<SplashScreenZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenZeroVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = SplashScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnNext.setOnClickListener {
        val destIntent = SplashScreenOneActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "SPLASH_SCREEN_ZERO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, SplashScreenZeroActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
