package com.blogspot.thengnet.modules.signupscreenzero.`data`.model

import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.di.MyApp

data class SignUpScreenZeroModel(
    /**
     * TODO Replace with dynamic value
     */
    var txtSignUp: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up),
    /**
     * TODO Replace with dynamic value
     */
    var txtInputRegistrationNumber: String? = MyApp.getInstance().resources.getString(R.string.dummy_registration_number),
    /**
     * TODO Replace with dynamic value
     */
    var txtSupportRegistrationNumber: String? =
        MyApp.getInstance().resources.getString(R.string.helper_wrong_registration_number),
    /**
     * TODO Replace with dynamic value
     */
    var txtInputEmail: String? = MyApp.getInstance().resources.getString(R.string.dummy_email),
    /**
     * TODO Replace with dynamic value
     */
    var txtSupportingEmail: String? =
        MyApp.getInstance().resources.getString(R.string.helper_wrong_email),
    /**
     * TODO Replace with dynamic value
     */
    var txtInputPhoneNumber: String? = MyApp.getInstance().resources.getString(R.string.dummy_phone_number)
)
