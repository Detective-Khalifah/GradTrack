package com.blogspot.thengnet.modules.enrollmentscreenzero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class EnrollmentScreenZeroModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_enrollment_code)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_supporting_text)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAlreadyenrolle: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_enrolle)

)
