package com.blogspot.thengnet.modules.forgotpasswordzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityForgotPasswordZeroBinding
import com.blogspot.thengnet.modules.forgotpasswordone.ui.ForgotPasswordOneActivity
import com.blogspot.thengnet.modules.forgotpasswordzero.data.viewmodel.ForgotPasswordZeroVM

class ForgotPasswordZeroActivity :
    BaseActivity<ActivityForgotPasswordZeroBinding>(R.layout.activity_forgot_password_zero) {
    private val viewModel: ForgotPasswordZeroVM by viewModels<ForgotPasswordZeroVM>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.forgotPasswordZeroVM = viewModel
    }

    override fun setUpClicks(): Unit {
        binding.btnChangeOtp.setOnClickListener {
            val destIntent = ForgotPasswordOneActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    companion object {
        const val TAG: String = "FORGOT_PASSWORD_ZERO_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, ForgotPasswordZeroActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
