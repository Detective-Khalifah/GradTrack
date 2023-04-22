package com.blogspot.thengnet.modules.signupscreentwo.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class Listlabeltext2RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.hint_address)

)
