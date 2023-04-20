package com.blogspot.thengnet.modules.dashboardzero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class DashboardZeroModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtViewDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextgraduation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_re_doing_gr)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeventyFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_75)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCurrentSemeste: String? =
      MyApp.getInstance().resources.getString(R.string.msg_current_semeste)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextenrolledc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enrolled_course)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtViewDetailsOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_view_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextfailedcou: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_failed_courses)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtViewDetailsTwo: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_view_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabel: String? = MyApp.getInstance().resources.getString(R.string.lbl_courses)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabelOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_dashboard)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabelTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_profile)

)
