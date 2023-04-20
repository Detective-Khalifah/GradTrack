package com.blogspot.thengnet.modules.dashboardzero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class CoursescardsRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTextcoursecod: String? = MyApp.getInstance().resources.getString(R.string.lbl_csc200)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeader: String? = MyApp.getInstance().resources.getString(R.string.msg_computer_progra)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSubhead: String? = MyApp.getInstance().resources.getString(R.string.msg_nam_adipiscing)

)
