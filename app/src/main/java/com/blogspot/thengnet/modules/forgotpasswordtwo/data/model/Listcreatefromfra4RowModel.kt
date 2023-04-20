package com.blogspot.thengnet.modules.forgotpasswordtwo.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class Listcreatefromfra4RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_new_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_enter_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_supporting_text)

)
