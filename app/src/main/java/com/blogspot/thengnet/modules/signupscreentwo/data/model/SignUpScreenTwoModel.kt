package com.blogspot.thengnet.modules.signupscreentwo.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class SignUpScreenTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUp: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPartCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_part_2)

)
