package com.blogspot.thengnet.modules.enrollmentscreenzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityEnrollmentScreenZeroBinding
import com.blogspot.thengnet.modules.enrollmentscreenone.ui.EnrollmentScreenOneActivity
import com.blogspot.thengnet.modules.enrollmentscreenzero.`data`.viewmodel.EnrollmentScreenZeroVM
import com.blogspot.thengnet.modules.signinscreenzero.ui.SignInScreenZeroActivity
import com.blogspot.thengnet.modules.signupscreenzero.ui.SignUpScreenZeroActivity
import kotlin.String
import kotlin.Unit

class EnrollmentScreenZeroActivity :
    BaseActivity<ActivityEnrollmentScreenZeroBinding>(R.layout.activity_enrollment_screen_zero) {
  private val viewModel: EnrollmentScreenZeroVM by viewModels<EnrollmentScreenZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.enrollmentScreenZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSignUp.setOnClickListener {
      val destIntent = SignUpScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnSignIn.setOnClickListener {
      val destIntent = SignInScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnEnroll.setOnClickListener {
      val destIntent = EnrollmentScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ENROLLMENT_SCREEN_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, EnrollmentScreenZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
