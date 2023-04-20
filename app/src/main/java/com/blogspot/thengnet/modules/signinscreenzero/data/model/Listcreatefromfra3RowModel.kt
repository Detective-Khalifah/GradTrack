package com.blogspot.thengnet.modules.signinscreenzero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class Listcreatefromfra3RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.msg_e_mail_or_phone)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.msg_enter_registere)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_supporting_text)

)
