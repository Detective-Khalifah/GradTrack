package com.blogspot.thengnet.modules.signupscreensix.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp

data class SignUpScreenSixModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.hint_phone_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.dummy_phone_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.helper_wrong_email)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUpOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPartCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_part_6)

)
