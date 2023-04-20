package com.blogspot.thengnet.modules.forgotpasswordtwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.thengnet.modules.forgotpasswordtwo.`data`.model.ForgotPasswordTwoModel
import com.blogspot.thengnet.modules.forgotpasswordtwo.`data`.model.Listcreatefromfra4RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ForgotPasswordTwoVM : ViewModel(), KoinComponent {
  val forgotPasswordTwoModel: MutableLiveData<ForgotPasswordTwoModel> =
      MutableLiveData(ForgotPasswordTwoModel())

  var navArguments: Bundle? = null

  val listcreatefromfraList: MutableLiveData<MutableList<Listcreatefromfra4RowModel>> =
      MutableLiveData(mutableListOf())
}
