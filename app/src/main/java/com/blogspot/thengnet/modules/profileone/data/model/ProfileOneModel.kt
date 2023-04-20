package com.blogspot.thengnet.modules.profileone.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class ProfileOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMakeprofilepu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_make_profile_pu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJohnDoe: String? = MyApp.getInstance().resources.getString(R.string.lbl_john_doe)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.msg_the_university)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_john_doe)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_mathematical_sc)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_computer_scienc)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextThree: String? =
      MyApp.getInstance().resources.getString(R.string.msg_graduation_year)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextFour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_completion_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextFive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_degree_type_do)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextSix: String? =
      MyApp.getInstance().resources.getString(R.string.msg_degree_class_s)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_language_s)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextEight: String? = MyApp.getInstance().resources.getString(R.string.lbl_cgpa)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextSeventeen: String? =
      MyApp.getInstance().resources.getString(R.string.msg_take_a_photo_us)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextEighteen: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_upload_from)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextNineteen: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_remove_photo)

)
