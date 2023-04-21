package com.blogspot.thengnet.modules.onboardingscreentwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityOnboardingScreenTwoBinding
import com.blogspot.thengnet.modules.enrollmentscreenzero.ui.EnrollmentScreenZeroActivity
import com.blogspot.thengnet.modules.onboardingscreenone.ui.OnboardingScreenOneActivity
import com.blogspot.thengnet.modules.onboardingscreentwo.data.viewmodel.OnboardingScreenTwoVM

class OnboardingScreenTwoActivity :
    BaseActivity<ActivityOnboardingScreenTwoBinding>(R.layout.activity_onboarding_screen_two) {
  private val viewModel: OnboardingScreenTwoVM by viewModels<OnboardingScreenTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.onboardingScreenTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnEnroll.setOnClickListener {
      val destIntent = EnrollmentScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPrevious.setOnClickListener {
      val destIntent = OnboardingScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ONBOARDING_SCREEN_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OnboardingScreenTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
