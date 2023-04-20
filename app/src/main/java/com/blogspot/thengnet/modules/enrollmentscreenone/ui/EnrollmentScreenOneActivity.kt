package com.blogspot.thengnet.modules.enrollmentscreenone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityEnrollmentScreenOneBinding
import com.blogspot.thengnet.modules.enrollmentscreenone.`data`.viewmodel.EnrollmentScreenOneVM
import com.blogspot.thengnet.modules.signupscreenzero.ui.SignUpScreenZeroActivity
import kotlin.String
import kotlin.Unit

class EnrollmentScreenOneActivity :
    BaseActivity<ActivityEnrollmentScreenOneBinding>(R.layout.activity_enrollment_screen_one) {
  private val viewModel: EnrollmentScreenOneVM by viewModels<EnrollmentScreenOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.enrollmentScreenOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSignUp.setOnClickListener {
      val destIntent = SignUpScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ENROLLMENT_SCREEN_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, EnrollmentScreenOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
