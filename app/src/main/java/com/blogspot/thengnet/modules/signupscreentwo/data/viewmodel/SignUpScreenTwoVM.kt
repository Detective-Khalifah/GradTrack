package com.blogspot.thengnet.modules.signupscreentwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreentwo.`data`.model.Listlabeltext2RowModel
import com.blogspot.thengnet.modules.signupscreentwo.`data`.model.SignUpScreenTwoModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenTwoVM : ViewModel(), KoinComponent {
  val signUpScreenTwoModel: MutableLiveData<SignUpScreenTwoModel> =
      MutableLiveData(SignUpScreenTwoModel())

  var navArguments: Bundle? = null

  val listlabeltextList: MutableLiveData<MutableList<Listlabeltext2RowModel>> =
      MutableLiveData(mutableListOf())
}
