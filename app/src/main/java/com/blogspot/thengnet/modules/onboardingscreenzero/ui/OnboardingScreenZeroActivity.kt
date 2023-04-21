package com.blogspot.thengnet.modules.onboardingscreenzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityOnboardingScreenZeroBinding
import com.blogspot.thengnet.modules.onboardingscreenone.ui.OnboardingScreenOneActivity
import com.blogspot.thengnet.modules.onboardingscreenzero.data.viewmodel.OnboardingScreenZeroVM

class OnboardingScreenZeroActivity :
    BaseActivity<ActivityOnboardingScreenZeroBinding>(R.layout.activity_onboarding_screen_zero) {
  private val viewModel: OnboardingScreenZeroVM by viewModels<OnboardingScreenZeroVM>()

  // TODO: Define a different splash screen comprising the svg only
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.onboardingScreenZeroVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = OnboardingScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnNext.setOnClickListener {
        val destIntent = OnboardingScreenOneActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "ONBOARDING_SCREEN_ZERO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, OnboardingScreenZeroActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
