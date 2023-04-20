package com.blogspot.thengnet.modules.courseszero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class CoursesZeroRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtInitial: String? = MyApp.getInstance().resources.getString(R.string.lbl_csc100)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeader: String? = MyApp.getInstance().resources.getString(R.string.msg_computer_progra2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSubhead: String? = MyApp.getInstance().resources.getString(R.string.msg_vitae_nec_leo_c)

)
