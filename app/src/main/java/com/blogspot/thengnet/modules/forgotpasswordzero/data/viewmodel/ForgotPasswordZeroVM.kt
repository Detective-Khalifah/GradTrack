package com.blogspot.thengnet.modules.forgotpasswordzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.forgotpasswordzero.`data`.model.ForgotPasswordZeroModel
import org.koin.core.KoinComponent

class ForgotPasswordZeroVM : ViewModel(), KoinComponent {
  val forgotPasswordZeroModel: MutableLiveData<ForgotPasswordZeroModel> =
      MutableLiveData(ForgotPasswordZeroModel())

  var navArguments: Bundle? = null
}
