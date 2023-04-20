package com.blogspot.thengnet.modules.signinscreenzero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.signinscreenzero.`data`.model.Listcreatefromfra3RowModel
import com.blogspot.thengnet.modules.signinscreenzero.`data`.model.SignInScreenZeroModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignInScreenZeroVM : ViewModel(), KoinComponent {
  val signInScreenZeroModel: MutableLiveData<SignInScreenZeroModel> =
      MutableLiveData(SignInScreenZeroModel())

  var navArguments: Bundle? = null

  val listcreatefromfraList: MutableLiveData<MutableList<Listcreatefromfra3RowModel>> =
      MutableLiveData(mutableListOf())
}
