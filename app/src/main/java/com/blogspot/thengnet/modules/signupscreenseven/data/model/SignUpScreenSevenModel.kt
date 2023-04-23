package com.blogspot.thengnet.modules.signupscreenseven.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class SignUpScreenSevenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPleaseenterth: String? =
      MyApp.getInstance().resources.getString(R.string.msg_please_enter_the_otp)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDidntreceive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_didn_t_receive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUpOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPartCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_part_7)

)
