package com.blogspot.thengnet.modules.signupscreenfour.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class ListcreatefromfraRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_e_mail)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_supporting_text)

)
