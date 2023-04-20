package com.blogspot.thengnet.modules.profileone.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class ProfileOneRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_nigerian)

)
