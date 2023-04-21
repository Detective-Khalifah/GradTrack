package com.blogspot.thengnet.modules.onboardingscreenzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.onboardingscreenzero.`data`.model.OnboardingScreenZeroModel
import org.koin.core.KoinComponent

class OnboardingScreenZeroVM : ViewModel(), KoinComponent {
  val mOnboardingScreenZeroModel: MutableLiveData<OnboardingScreenZeroModel> =
      MutableLiveData(OnboardingScreenZeroModel())

  var navArguments: Bundle? = null
}
