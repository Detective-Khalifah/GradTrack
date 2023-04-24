package com.blogspot.thengnet.modules.coursesOne.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.coursesOne.`data`.model.CoursesOneModel
import org.koin.core.KoinComponent

class CoursesOneVM : ViewModel(), KoinComponent {
  val mCoursesOneModel: MutableLiveData<CoursesOneModel> = MutableLiveData(CoursesOneModel())

  var navArguments: Bundle? = null
}
