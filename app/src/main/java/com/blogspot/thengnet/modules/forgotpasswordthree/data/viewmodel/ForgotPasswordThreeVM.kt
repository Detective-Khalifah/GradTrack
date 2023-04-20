package com.blogspot.thengnet.modules.forgotpasswordthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.forgotpasswordthree.`data`.model.ForgotPasswordThreeModel
import org.koin.core.KoinComponent

class ForgotPasswordThreeVM : ViewModel(), KoinComponent {
  val forgotPasswordThreeModel: MutableLiveData<ForgotPasswordThreeModel> =
      MutableLiveData(ForgotPasswordThreeModel())

  var navArguments: Bundle? = null
}
