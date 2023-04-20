package com.blogspot.thengnet.modules.enrollmentscreenzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.enrollmentscreenzero.`data`.model.EnrollmentScreenZeroModel
import org.koin.core.KoinComponent

class EnrollmentScreenZeroVM : ViewModel(), KoinComponent {
  val enrollmentScreenZeroModel: MutableLiveData<EnrollmentScreenZeroModel> =
      MutableLiveData(EnrollmentScreenZeroModel())

  var navArguments: Bundle? = null
}
