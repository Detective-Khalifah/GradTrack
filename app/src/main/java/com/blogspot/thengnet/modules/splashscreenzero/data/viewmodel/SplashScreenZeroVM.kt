package com.blogspot.thengnet.modules.splashscreenzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.splashscreenzero.`data`.model.SplashScreenZeroModel
import org.koin.core.KoinComponent

class SplashScreenZeroVM : ViewModel(), KoinComponent {
  val splashScreenZeroModel: MutableLiveData<SplashScreenZeroModel> =
      MutableLiveData(SplashScreenZeroModel())

  var navArguments: Bundle? = null
}
