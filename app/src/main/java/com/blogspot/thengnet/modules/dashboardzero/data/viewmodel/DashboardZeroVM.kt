package com.blogspot.thengnet.modules.dashboardzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.CoursescardsRowModel
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.DashboardZeroModel
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.ListinitialRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class DashboardZeroVM : ViewModel(), KoinComponent {
  val dashboardZeroModel: MutableLiveData<DashboardZeroModel> =
      MutableLiveData(DashboardZeroModel())

  var navArguments: Bundle? = null

  val coursesCardsList: MutableLiveData<MutableList<CoursescardsRowModel>> =
      MutableLiveData(mutableListOf())

  val listinitialList: MutableLiveData<MutableList<ListinitialRowModel>> =
      MutableLiveData(mutableListOf())
}
