package com.blogspot.thengnet.modules.signupscreenzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreenzero.`data`.model.ListlabeltextRowModel
import com.blogspot.thengnet.modules.signupscreenzero.`data`.model.SignUpScreenZeroModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUpScreenZeroVM : ViewModel(), KoinComponent {
  val signUpScreenZeroModel: MutableLiveData<SignUpScreenZeroModel> =
      MutableLiveData(SignUpScreenZeroModel())

  var navArguments: Bundle? = null

  val listlabeltextList: MutableLiveData<MutableList<ListlabeltextRowModel>> =
      MutableLiveData(mutableListOf())
}
