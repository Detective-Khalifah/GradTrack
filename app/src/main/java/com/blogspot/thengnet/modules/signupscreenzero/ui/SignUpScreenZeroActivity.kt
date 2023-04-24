package com.blogspot.thengnet.modules.signupscreenzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenZeroBinding
import com.blogspot.thengnet.modules.signupscreenseven.ui.SignUpScreenSevenActivity
import com.blogspot.thengnet.modules.signupscreenzero.data.model.ListlabeltextRowModel
import com.blogspot.thengnet.modules.signupscreenzero.data.viewmodel.SignUpScreenZeroVM

class SignUpScreenZeroActivity :
    BaseActivity<ActivitySignUpScreenZeroBinding>(R.layout.activity_sign_up_screen_zero) {
  private val viewModel: SignUpScreenZeroVM by viewModels<SignUpScreenZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
//    val listlabeltextAdapter =
//    ListlabeltextAdapter(viewModel.listlabeltextList.value?:mutableListOf())
////    binding.recyclerListlabeltext.adapter = listlabeltextAdapter
//    listlabeltextAdapter.setOnItemClickListener(
//    object : ListlabeltextAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : ListlabeltextRowModel) {
//        onClickRecyclerListlabeltext(view, position, item)
//      }
//    }
//    )
//    viewModel.listlabeltextList.observe(this) {
//      listlabeltextAdapter.updateData(it)
//    }
    binding.signUpScreenZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSignUp.setOnClickListener {
      val destIntent = SignUpScreenSevenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListlabeltext(
    view: View,
    position: Int,
    item: ListlabeltextRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
