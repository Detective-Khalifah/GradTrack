package com.blogspot.thengnet.modules.signinscreenzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignInScreenZeroBinding
import com.blogspot.thengnet.modules.dashboardzero.ui.DashboardZeroActivity
import com.blogspot.thengnet.modules.forgotpasswordzero.ui.ForgotPasswordZeroActivity
import com.blogspot.thengnet.modules.signinscreenzero.data.model.Listcreatefromfra3RowModel
import com.blogspot.thengnet.modules.signinscreenzero.data.viewmodel.SignInScreenZeroVM
import com.blogspot.thengnet.modules.signupscreenzero.ui.SignUpScreenZeroActivity

class SignInScreenZeroActivity :
    BaseActivity<ActivitySignInScreenZeroBinding>(R.layout.activity_sign_in_screen_zero) {
  private val viewModel: SignInScreenZeroVM by viewModels<SignInScreenZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
//    val listcreatefromfraAdapter =
//    ListcreatefromfraAdapter(viewModel.listcreatefromfraList.value?:mutableListOf())
//    binding.recyclerListcreatefromfra.adapter = listcreatefromfraAdapter
//    listcreatefromfraAdapter.setOnItemClickListener(
//    object : ListcreatefromfraAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : Listcreatefromfra3RowModel) {
//        onClickRecyclerListcreatefromfra(view, position, item)
//      }
//    }
//    )
//    viewModel.listcreatefromfraList.observe(this) {
//      listcreatefromfraAdapter.updateData(it)
//    }
    binding.signInScreenZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtConfirmation.setOnClickListener {
      val destIntent = SignUpScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtForgotPwd.setOnClickListener {
      val destIntent = ForgotPasswordZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
//    binding.imageArrowleft.setOnClickListener {
//      finish()
//    }
//    binding.txtLanguage.setOnClickListener {
//      val destIntent = ForgotPasswordZeroActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.btnSignIn.setOnClickListener {
      val destIntent = DashboardZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListcreatefromfra(
    view: View,
    position: Int,
    item: Listcreatefromfra3RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_IN_SCREEN_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignInScreenZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
