package com.blogspot.thengnet.modules.onboardingscreenone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityOnboardingScreenOneBinding
import com.blogspot.thengnet.modules.onboardingscreenone.data.viewmodel.OnboardingScreenOneVM
import com.blogspot.thengnet.modules.onboardingscreentwo.ui.OnboardingScreenTwoActivity
import com.blogspot.thengnet.modules.onboardingscreenzero.ui.OnboardingScreenZeroActivity

class OnboardingScreenOneActivity :
    BaseActivity<ActivityOnboardingScreenOneBinding>(R.layout.activity_onboarding_screen_one) {
  private val viewModel: OnboardingScreenOneVM by viewModels<OnboardingScreenOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.onboardingScreenOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPrevious.setOnClickListener {
      val destIntent = OnboardingScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnNext.setOnClickListener {
      val destIntent = OnboardingScreenTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ONBOARDING_SCREEN_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OnboardingScreenOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
