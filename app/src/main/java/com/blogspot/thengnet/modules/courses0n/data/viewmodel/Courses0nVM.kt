package com.blogspot.thengnet.modules.courses0n.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.courses0n.`data`.model.Courses0nModel
import org.koin.core.KoinComponent

class Courses0nVM : ViewModel(), KoinComponent {
  val courses0nModel: MutableLiveData<Courses0nModel> = MutableLiveData(Courses0nModel())

  var navArguments: Bundle? = null
}
