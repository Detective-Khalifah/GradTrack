package com.blogspot.thengnet.modules.signupscreenfive.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class Listcreatefromfra1RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextOne: String? = MyApp.getInstance().resources.getString(R.string.hint_phone_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_supporting_text)

)
