package com.blogspot.thengnet.modules.forgotpasswordthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityForgotPasswordThreeBinding
import com.blogspot.thengnet.modules.forgotpasswordthree.`data`.viewmodel.ForgotPasswordThreeVM
import com.blogspot.thengnet.modules.signinscreenzero.ui.SignInScreenZeroActivity
import kotlin.String
import kotlin.Unit

class ForgotPasswordThreeActivity :
    BaseActivity<ActivityForgotPasswordThreeBinding>(R.layout.activity_forgot_password_three) {
  private val viewModel: ForgotPasswordThreeVM by viewModels<ForgotPasswordThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.forgotPasswordThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSignIn.setOnClickListener {
      val destIntent = SignInScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FORGOT_PASSWORD_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ForgotPasswordThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
