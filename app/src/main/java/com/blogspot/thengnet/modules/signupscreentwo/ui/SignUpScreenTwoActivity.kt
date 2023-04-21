package com.blogspot.thengnet.modules.signupscreentwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenTwoBinding
import com.blogspot.thengnet.modules.signupscreenone.ui.SignUpScreenOneActivity
import com.blogspot.thengnet.modules.signupscreenthree.ui.SignUpScreenThreeActivity
import com.blogspot.thengnet.modules.signupscreentwo.data.model.Listlabeltext2RowModel
import com.blogspot.thengnet.modules.signupscreentwo.data.viewmodel.SignUpScreenTwoVM

class SignUpScreenTwoActivity :
    BaseActivity<ActivitySignUpScreenTwoBinding>(R.layout.activity_sign_up_screen_two) {
  private val viewModel: SignUpScreenTwoVM by viewModels<SignUpScreenTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listlabeltextAdapter =
    ListlabeltextAdapter(viewModel.listlabeltextList.value?:mutableListOf())
    binding.recyclerListlabeltext.adapter = listlabeltextAdapter
    listlabeltextAdapter.setOnItemClickListener(
    object : ListlabeltextAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listlabeltext2RowModel) {
        onClickRecyclerListlabeltext(view, position, item)
      }
    }
    )
    viewModel.listlabeltextList.observe(this) {
      listlabeltextAdapter.updateData(it)
    }
    binding.signUpScreenTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearPrevNextButton.setOnClickListener {
      val destIntent = SignUpScreenThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = SignUpScreenOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListlabeltext(
    view: View,
    position: Int,
    item: Listlabeltext2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
