package com.blogspot.thengnet.modules.signupscreenfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenFourBinding
import com.blogspot.thengnet.modules.signupscreenfive.ui.SignUpScreenFiveActivity
import com.blogspot.thengnet.modules.signupscreenfour.data.model.ListcreatefromfraRowModel
import com.blogspot.thengnet.modules.signupscreenfour.data.viewmodel.SignUpScreenFourVM
import com.blogspot.thengnet.modules.signupscreenthree.ui.SignUpScreenThreeActivity

class SignUpScreenFourActivity :
    BaseActivity<ActivitySignUpScreenFourBinding>(R.layout.activity_sign_up_screen_four) {
  private val viewModel: SignUpScreenFourVM by viewModels<SignUpScreenFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listcreatefromfraAdapter =
    ListcreatefromfraAdapter(viewModel.listcreatefromfraList.value?:mutableListOf())
    binding.recyclerListcreatefromfra.adapter = listcreatefromfraAdapter
    listcreatefromfraAdapter.setOnItemClickListener(
    object : ListcreatefromfraAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListcreatefromfraRowModel) {
        onClickRecyclerListcreatefromfra(view, position, item)
      }
    }
    )
    viewModel.listcreatefromfraList.observe(this) {
      listcreatefromfraAdapter.updateData(it)
    }
    binding.signUpScreenFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearPrevNextButton.setOnClickListener {
      val destIntent = SignUpScreenFiveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = SignUpScreenThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListcreatefromfra(
    view: View,
    position: Int,
    item: ListcreatefromfraRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
