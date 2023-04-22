package com.blogspot.thengnet.modules.signupscreenfive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivitySignUpScreenFiveBinding
import com.blogspot.thengnet.modules.signupscreenfive.data.model.Listcreatefromfra1RowModel
import com.blogspot.thengnet.modules.signupscreenfive.data.viewmodel.SignUpScreenFiveVM
import com.blogspot.thengnet.modules.signupscreenfour.ui.SignUpScreenFourActivity
import com.blogspot.thengnet.modules.signupscreensix.ui.SignUpScreenSixActivity

class SignUpScreenFiveActivity :
    BaseActivity<ActivitySignUpScreenFiveBinding>(R.layout.activity_sign_up_screen_five) {
  private val viewModel: SignUpScreenFiveVM by viewModels<SignUpScreenFiveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
//    val listcreatefromfraAdapter =
//    ListcreatefromfraAdapter(viewModel.listcreatefromfraList.value?:mutableListOf())
//    binding.recyclerListcreatefromfra.adapter = listcreatefromfraAdapter
//    listcreatefromfraAdapter.setOnItemClickListener(
//    object : ListcreatefromfraAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : Listcreatefromfra1RowModel) {
//        onClickRecyclerListcreatefromfra(view, position, item)
//      }
//    }
//    )
//    viewModel.listcreatefromfraList.observe(this) {
//      listcreatefromfraAdapter.updateData(it)
//    }
    binding.signUpScreenFiveVM = viewModel
  }

  override fun setUpClicks(): Unit {
//    binding.imageArrowleft.setOnClickListener {
//      val destIntent = SignUpScreenFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.imageArrowleft.setOnClickListener {
//      finish()
//    }
    binding.btnNext.setOnClickListener {
      val destIntent = SignUpScreenSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPrevious.setOnClickListener {
      val destIntent = SignUpScreenFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListcreatefromfra(
    view: View,
    position: Int,
    item: Listcreatefromfra1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_SCREEN_FIVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpScreenFiveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
