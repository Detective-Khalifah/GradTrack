package com.blogspot.thengnet.modules.dashboardone.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class DashboardOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBack: String? = MyApp.getInstance().resources.getString(R.string.lbl_back)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFirst: String? = MyApp.getInstance().resources.getString(R.string.lbl_1st)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSecond: String? = MyApp.getInstance().resources.getString(R.string.lbl_2nd)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThird: String? = MyApp.getInstance().resources.getString(R.string.lbl_3rd)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFourth: String? = MyApp.getInstance().resources.getString(R.string.lbl_4th)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFifth: String? = MyApp.getInstance().resources.getString(R.string.lbl_5th)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAcademicYears: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_academic_years)
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
  var txtViewDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_details)
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
  var txtViewDetailsOne: String? =
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
