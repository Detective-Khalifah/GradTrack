package com.blogspot.thengnet.modules.signupscreenfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreenfour.`data`.model.ListcreatefromfraRowModel
import com.blogspot.thengnet.modules.signupscreenfour.`data`.model.SignUpScreenFourModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenFourVM : ViewModel(), KoinComponent {
  val signUpScreenFourModel: MutableLiveData<SignUpScreenFourModel> =
      MutableLiveData(SignUpScreenFourModel())

  var navArguments: Bundle? = null

  val listcreatefromfraList: MutableLiveData<MutableList<ListcreatefromfraRowModel>> =
      MutableLiveData(mutableListOf())
}
