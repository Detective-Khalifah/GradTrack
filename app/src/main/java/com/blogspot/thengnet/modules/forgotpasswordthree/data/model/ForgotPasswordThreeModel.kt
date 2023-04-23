package com.blogspot.thengnet.modules.forgotpasswordthree.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class ForgotPasswordThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPasswordsucces: String? =
      MyApp.getInstance().resources.getString(R.string.msg_password_reset_successfully)

)
