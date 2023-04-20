package com.blogspot.thengnet.modules.signupscreenseven.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenSevenBinding
import com.blogspot.thengnet.modules.dashboardzero.ui.DashboardZeroActivity
import com.blogspot.thengnet.modules.signupscreenseven.`data`.viewmodel.SignUpScreenSevenVM
import com.blogspot.thengnet.modules.signupscreensix.ui.SignUpScreenSixActivity
import kotlin.String
import kotlin.Unit

class SignUpScreenSevenActivity :
    BaseActivity<ActivitySignUpScreenSevenBinding>(R.layout.activity_sign_up_screen_seven) {
  private val viewModel: SignUpScreenSevenVM by viewModels<SignUpScreenSevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUpScreenSevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = SignUpScreenSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearPrevNextButto.setOnClickListener {
      val destIntent = DashboardZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_SEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenSevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
