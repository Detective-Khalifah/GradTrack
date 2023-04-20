package com.blogspot.thengnet.modules.profilezero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class ProfileZeroRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextTwelve: String? = MyApp.getInstance().resources.getString(R.string.lbl_nigerian)

)
