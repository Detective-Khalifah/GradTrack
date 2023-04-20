package com.blogspot.thengnet.modules.enrollmentscreenone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.enrollmentscreenone.`data`.model.EnrollmentScreenOneModel
import org.koin.core.KoinComponent

class EnrollmentScreenOneVM : ViewModel(), KoinComponent {
  val enrollmentScreenOneModel: MutableLiveData<EnrollmentScreenOneModel> =
      MutableLiveData(EnrollmentScreenOneModel())

  var navArguments: Bundle? = null
}
