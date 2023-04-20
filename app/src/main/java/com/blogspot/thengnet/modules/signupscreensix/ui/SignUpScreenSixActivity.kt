package com.blogspot.thengnet.modules.signupscreensix.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenSixBinding
import com.blogspot.thengnet.modules.signupscreenfive.ui.SignUpScreenFiveActivity
import com.blogspot.thengnet.modules.signupscreenseven.ui.SignUpScreenSevenActivity
import com.blogspot.thengnet.modules.signupscreensix.`data`.model.Listcreatefromfra2RowModel
import com.blogspot.thengnet.modules.signupscreensix.`data`.viewmodel.SignUpScreenSixVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SignUpScreenSixActivity :
    BaseActivity<ActivitySignUpScreenSixBinding>(R.layout.activity_sign_up_screen_six) {
  private val viewModel: SignUpScreenSixVM by viewModels<SignUpScreenSixVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listcreatefromfraAdapter =
    ListcreatefromfraAdapter(viewModel.listcreatefromfraList.value?:mutableListOf())
    binding.recyclerListcreatefromfra.adapter = listcreatefromfraAdapter
    listcreatefromfraAdapter.setOnItemClickListener(
    object : ListcreatefromfraAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listcreatefromfra2RowModel) {
        onClickRecyclerListcreatefromfra(view, position, item)
      }
    }
    )
    viewModel.listcreatefromfraList.observe(this) {
      listcreatefromfraAdapter.updateData(it)
    }
    binding.signUpScreenSixVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenFiveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = SignUpScreenFiveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearPrevNextButto.setOnClickListener {
      val destIntent = SignUpScreenSevenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListcreatefromfra(
    view: View,
    position: Int,
    item: Listcreatefromfra2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_SIX_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenSixActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
