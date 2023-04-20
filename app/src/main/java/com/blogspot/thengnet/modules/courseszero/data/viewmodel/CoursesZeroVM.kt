package com.blogspot.thengnet.modules.courseszero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.courseszero.`data`.model.CoursesZeroModel
import com.blogspot.thengnet.modules.courseszero.`data`.model.CoursesZeroRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class CoursesZeroVM : ViewModel(), KoinComponent {
  val coursesZeroModel: MutableLiveData<CoursesZeroModel> = MutableLiveData(CoursesZeroModel())

  var navArguments: Bundle? = null

  val coursesZeroList: MutableLiveData<MutableList<CoursesZeroRowModel>> =
      MutableLiveData(mutableListOf())
}
