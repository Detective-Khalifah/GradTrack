package com.blogspot.thengnet.modules.signupscreenfour.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp

data class SignUpScreenFourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.hint_registration_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.dummy_registration_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.helper_wrong_registration_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUp: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPartCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_part_4)

)
