package com.blogspot.thengnet.modules.signupscreenfour.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class SignUpScreenFourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.msg_registration_nu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_aaaa_bbb_ccc_dd)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.msg_if_this_isn_t_y)
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
