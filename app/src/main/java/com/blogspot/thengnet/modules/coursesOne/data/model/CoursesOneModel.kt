package com.blogspot.thengnet.modules.coursesOne.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class CoursesOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_lorem_ipsum_dol)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextenrolledc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_computer_progra)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStatistics: String? = MyApp.getInstance().resources.getString(R.string.lbl_statistics)

)
