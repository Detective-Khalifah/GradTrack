package com.blogspot.thengnet.modules.onboardingscreenone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.onboardingscreenone.`data`.model.OnboardingScreenOneModel
import org.koin.core.KoinComponent

class OnboardingScreenOneVM : ViewModel(), KoinComponent {
  val mOnboardingScreenOneModel: MutableLiveData<OnboardingScreenOneModel> =
      MutableLiveData(OnboardingScreenOneModel())

  var navArguments: Bundle? = null
}
