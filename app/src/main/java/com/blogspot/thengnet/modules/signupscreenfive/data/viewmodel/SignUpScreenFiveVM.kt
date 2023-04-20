package com.blogspot.thengnet.modules.signupscreenfive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreenfive.`data`.model.Listcreatefromfra1RowModel
import com.blogspot.thengnet.modules.signupscreenfive.`data`.model.SignUpScreenFiveModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenFiveVM : ViewModel(), KoinComponent {
  val signUpScreenFiveModel: MutableLiveData<SignUpScreenFiveModel> =
      MutableLiveData(SignUpScreenFiveModel())

  var navArguments: Bundle? = null

  val listcreatefromfraList: MutableLiveData<MutableList<Listcreatefromfra1RowModel>> =
      MutableLiveData(mutableListOf())
}
