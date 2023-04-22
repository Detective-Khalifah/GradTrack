package com.blogspot.thengnet.modules.signupscreenzero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp
import kotlin.String

data class ListlabeltextRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.hint_first_name)

)
