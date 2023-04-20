package com.blogspot.thengnet.modules.signupscreenseven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signupscreenseven.`data`.model.SignUpScreenSevenModel
import org.koin.core.KoinComponent

class SignUpScreenSevenVM : ViewModel(), KoinComponent {
  val signUpScreenSevenModel: MutableLiveData<SignUpScreenSevenModel> =
      MutableLiveData(SignUpScreenSevenModel())

  var navArguments: Bundle? = null
}
