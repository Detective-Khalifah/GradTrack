package com.blogspot.thengnet.modules.signupscreenone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreenone.`data`.model.Listlabeltext1RowModel
import com.blogspot.thengnet.modules.signupscreenone.`data`.model.SignUpScreenOneModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenOneVM : ViewModel(), KoinComponent {
  val signUpScreenOneModel: MutableLiveData<SignUpScreenOneModel> =
      MutableLiveData(SignUpScreenOneModel())

  var navArguments: Bundle? = null

  val listlabeltextList: MutableLiveData<MutableList<Listlabeltext1RowModel>> =
      MutableLiveData(mutableListOf())
}
