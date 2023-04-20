package com.blogspot.thengnet.modules.signupscreensix.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreensix.`data`.model.Listcreatefromfra2RowModel
import com.blogspot.thengnet.modules.signupscreensix.`data`.model.SignUpScreenSixModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenSixVM : ViewModel(), KoinComponent {
  val signUpScreenSixModel: MutableLiveData<SignUpScreenSixModel> =
      MutableLiveData(SignUpScreenSixModel())

  var navArguments: Bundle? = null

  val listcreatefromfraList: MutableLiveData<MutableList<Listcreatefromfra2RowModel>> =
      MutableLiveData(mutableListOf())
}
