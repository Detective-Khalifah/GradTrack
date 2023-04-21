package com.blogspot.thengnet.modules.signupscreenthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenThreeBinding
import com.blogspot.thengnet.modules.signupscreenfour.ui.SignUpScreenFourActivity
import com.blogspot.thengnet.modules.signupscreenthree.data.model.Listlabeltext3RowModel
import com.blogspot.thengnet.modules.signupscreenthree.data.viewmodel.SignUpScreenThreeVM
import com.blogspot.thengnet.modules.signupscreentwo.ui.SignUpScreenTwoActivity

class SignUpScreenThreeActivity :
    BaseActivity<ActivitySignUpScreenThreeBinding>(R.layout.activity_sign_up_screen_three) {
  private val viewModel: SignUpScreenThreeVM by viewModels<SignUpScreenThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listlabeltextAdapter =
    ListlabeltextAdapter(viewModel.listlabeltextList.value?:mutableListOf())
    binding.recyclerListlabeltext.adapter = listlabeltextAdapter
    listlabeltextAdapter.setOnItemClickListener(
    object : ListlabeltextAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listlabeltext3RowModel) {
        onClickRecyclerListlabeltext(view, position, item)
      }
    }
    )
    viewModel.listlabeltextList.observe(this) {
      listlabeltextAdapter.updateData(it)
    }
    binding.signUpScreenThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearPrevNextButton.setOnClickListener {
      val destIntent = SignUpScreenFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = SignUpScreenTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListlabeltext(
    view: View,
    position: Int,
    item: Listlabeltext3RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
