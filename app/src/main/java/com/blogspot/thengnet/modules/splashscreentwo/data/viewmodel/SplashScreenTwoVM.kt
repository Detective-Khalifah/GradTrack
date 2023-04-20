package com.blogspot.thengnet.modules.splashscreentwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.splashscreentwo.`data`.model.SplashScreenTwoModel
import org.koin.core.KoinComponent

class SplashScreenTwoVM : ViewModel(), KoinComponent {
  val splashScreenTwoModel: MutableLiveData<SplashScreenTwoModel> =
      MutableLiveData(SplashScreenTwoModel())

  var navArguments: Bundle? = null
}
