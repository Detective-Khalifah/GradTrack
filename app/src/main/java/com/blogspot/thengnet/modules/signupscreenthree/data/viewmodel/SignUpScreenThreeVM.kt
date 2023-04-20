package com.blogspot.thengnet.modules.signupscreenthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreenthree.`data`.model.Listlabeltext3RowModel
import com.blogspot.thengnet.modules.signupscreenthree.`data`.model.SignUpScreenThreeModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenThreeVM : ViewModel(), KoinComponent {
  val signUpScreenThreeModel: MutableLiveData<SignUpScreenThreeModel> =
      MutableLiveData(SignUpScreenThreeModel())

  var navArguments: Bundle? = null

  val listlabeltextList: MutableLiveData<MutableList<Listlabeltext3RowModel>> =
      MutableLiveData(mutableListOf())
}
