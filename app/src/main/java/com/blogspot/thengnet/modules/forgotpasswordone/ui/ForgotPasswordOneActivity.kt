package com.blogspot.thengnet.modules.forgotpasswordone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityForgotPasswordOneBinding
import com.blogspot.thengnet.modules.forgotpasswordone.`data`.viewmodel.ForgotPasswordOneVM
import com.blogspot.thengnet.modules.forgotpasswordtwo.ui.ForgotPasswordTwoActivity
import kotlin.String
import kotlin.Unit

class ForgotPasswordOneActivity :
    BaseActivity<ActivityForgotPasswordOneBinding>(R.layout.activity_forgot_password_one) {
  private val viewModel: ForgotPasswordOneVM by viewModels<ForgotPasswordOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.forgotPasswordOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnResetPassword.setOnClickListener {
      val destIntent = ForgotPasswordTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FORGOT_PASSWORD_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ForgotPasswordOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
