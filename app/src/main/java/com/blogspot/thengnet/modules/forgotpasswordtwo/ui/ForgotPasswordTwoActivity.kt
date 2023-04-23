package com.blogspot.thengnet.modules.forgotpasswordtwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityForgotPasswordTwoBinding
import com.blogspot.thengnet.modules.forgotpasswordthree.ui.ForgotPasswordThreeActivity
import com.blogspot.thengnet.modules.forgotpasswordtwo.data.model.Listcreatefromfra4RowModel
import com.blogspot.thengnet.modules.forgotpasswordtwo.data.viewmodel.ForgotPasswordTwoVM

class ForgotPasswordTwoActivity :
    BaseActivity<ActivityForgotPasswordTwoBinding>(R.layout.activity_forgot_password_two) {
  private val viewModel: ForgotPasswordTwoVM by viewModels<ForgotPasswordTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
//    val listcreatefromfraAdapter =
//    ListcreatefromfraAdapter(viewModel.listcreatefromfraList.value?:mutableListOf())
//    binding.recyclerListcreatefromfra.adapter = listcreatefromfraAdapter
//    listcreatefromfraAdapter.setOnItemClickListener(
//    object : ListcreatefromfraAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : Listcreatefromfra4RowModel) {
//        onClickRecyclerListcreatefromfra(view, position, item)
//      }
//    }
//    )
//    viewModel.listcreatefromfraList.observe(this) {
//      listcreatefromfraAdapter.updateData(it)
//    }
    binding.forgotPasswordTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnResetPassword.setOnClickListener {
      val destIntent = ForgotPasswordThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListcreatefromfra(
    view: View,
    position: Int,
    item: Listcreatefromfra4RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "FORGOT_PASSWORD_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ForgotPasswordTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
