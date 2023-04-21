package com.blogspot.thengnet.modules.onboardingscreentwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.onboardingscreentwo.`data`.model.OnboardingScreenTwoModel
import org.koin.core.KoinComponent

class OnboardingScreenTwoVM : ViewModel(), KoinComponent {
  val mOnboardingScreenTwoModel: MutableLiveData<OnboardingScreenTwoModel> =
      MutableLiveData(OnboardingScreenTwoModel())

  var navArguments: Bundle? = null
}
