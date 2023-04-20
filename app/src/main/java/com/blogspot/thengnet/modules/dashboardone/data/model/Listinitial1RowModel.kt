package com.blogspot.thengnet.modules.dashboardone.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class Listinitial1RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtInitial: String? = MyApp.getInstance().resources.getString(R.string.lbl_csc100)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeaderFour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_computer_progra2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSubheadFour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_vitae_nec_leo_c)

)
