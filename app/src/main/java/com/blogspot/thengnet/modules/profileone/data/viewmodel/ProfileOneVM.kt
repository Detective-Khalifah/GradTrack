package com.blogspot.thengnet.modules.profileone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.profileone.`data`.model.ProfileOneModel
import com.blogspot.thengnet.modules.profileone.`data`.model.ProfileOneRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ProfileOneVM : ViewModel(), KoinComponent {
  val profileOneModel: MutableLiveData<ProfileOneModel> = MutableLiveData(ProfileOneModel())

  var navArguments: Bundle? = null

  val profileOneList: MutableLiveData<MutableList<ProfileOneRowModel>> =
      MutableLiveData(mutableListOf())
}
