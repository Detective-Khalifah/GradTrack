package com.blogspot.thengnet.modules.enrollmentscreenone.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class EnrollmentScreenOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYoureenrolled: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_re_enrolled)

)
