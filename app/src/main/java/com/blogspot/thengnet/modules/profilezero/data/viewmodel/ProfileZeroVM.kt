package com.blogspot.thengnet.modules.profilezero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.profilezero.`data`.model.ProfileZeroModel
import com.blogspot.thengnet.modules.profilezero.`data`.model.ProfileZeroRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ProfileZeroVM : ViewModel(), KoinComponent {
  val profileZeroModel: MutableLiveData<ProfileZeroModel> = MutableLiveData(ProfileZeroModel())

  var navArguments: Bundle? = null

  val profileZeroList: MutableLiveData<MutableList<ProfileZeroRowModel>> =
      MutableLiveData(mutableListOf())
}
