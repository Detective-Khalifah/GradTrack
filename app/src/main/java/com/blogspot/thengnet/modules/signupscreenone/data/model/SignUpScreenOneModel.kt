package com.blogspot.thengnet.modules.signupscreenone.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class SignUpScreenOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUp: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFloatingLabel: String? = MyApp.getInstance().resources.getString(R.string.lbl_nationality)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInput: String? = MyApp.getInstance().resources.getString(R.string.lbl_country)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtItemCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_item_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtItemCounterOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_item_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtItemCounterTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_item_3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtItemCounterThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_item_4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPartCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_part_1)

)
