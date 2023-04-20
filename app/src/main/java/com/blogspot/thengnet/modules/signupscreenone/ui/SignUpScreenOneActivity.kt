package com.blogspot.thengnet.modules.signupscreenone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenOneBinding
import com.blogspot.thengnet.modules.signupscreenone.`data`.model.Listlabeltext1RowModel
import com.blogspot.thengnet.modules.signupscreenone.`data`.viewmodel.SignUpScreenOneVM
import com.blogspot.thengnet.modules.signupscreentwo.ui.SignUpScreenTwoActivity
import com.blogspot.thengnet.modules.signupscreenzero.ui.SignUpScreenZeroActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SignUpScreenOneActivity :
    BaseActivity<ActivitySignUpScreenOneBinding>(R.layout.activity_sign_up_screen_one) {
  private val viewModel: SignUpScreenOneVM by viewModels<SignUpScreenOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listlabeltextAdapter =
    ListlabeltextAdapter(viewModel.listlabeltextList.value?:mutableListOf())
    binding.recyclerListlabeltext.adapter = listlabeltextAdapter
    listlabeltextAdapter.setOnItemClickListener(
    object : ListlabeltextAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listlabeltext1RowModel) {
        onClickRecyclerListlabeltext(view, position, item)
      }
    }
    )
    viewModel.listlabeltextList.observe(this) {
      listlabeltextAdapter.updateData(it)
    }
    binding.signUpScreenOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = SignUpScreenTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = SignUpScreenZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListlabeltext(
    view: View,
    position: Int,
    item: Listlabeltext1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
