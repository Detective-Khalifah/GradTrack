package com.blogspot.thengnet.modules.dashboardone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.dashboardone.`data`.model.Coursescards1RowModel
import com.blogspot.thengnet.modules.dashboardone.`data`.model.DashboardOneModel
import com.blogspot.thengnet.modules.dashboardone.`data`.model.Listinitial1RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class DashboardOneVM : ViewModel(), KoinComponent {
  val dashboardOneModel: MutableLiveData<DashboardOneModel> = MutableLiveData(DashboardOneModel())

  var navArguments: Bundle? = null

  val coursesCardsList: MutableLiveData<MutableList<Coursescards1RowModel>> =
      MutableLiveData(mutableListOf())

  val listinitialList: MutableLiveData<MutableList<Listinitial1RowModel>> =
      MutableLiveData(mutableListOf())
}
