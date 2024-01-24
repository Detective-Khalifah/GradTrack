package com.blogspot.thengnet.modules.signupscreenzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.data.State
import com.blogspot.thengnet.data.StateAdapter
import com.blogspot.thengnet.data.States
import com.blogspot.thengnet.databinding.ActivitySignUpScreenZeroBinding
import com.blogspot.thengnet.modules.signupscreenseven.ui.SignUpScreenSevenActivity
import com.blogspot.thengnet.modules.signupscreenzero.data.model.ListlabeltextRowModel
import com.blogspot.thengnet.modules.signupscreenzero.data.viewmodel.SignUpScreenZeroVM
import com.google.gson.Gson

class SignUpScreenZeroActivity :
    BaseActivity<ActivitySignUpScreenZeroBinding>(R.layout.activity_sign_up_screen_zero) {

    private val LOG_TAG = SignUpScreenZeroActivity::class.java.name
    private val viewModel: SignUpScreenZeroVM by viewModels<SignUpScreenZeroVM>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
//    val listlabeltextAdapter =
//    ListlabeltextAdapter(viewModel.listlabeltextList.value?:mutableListOf())
////    binding.recyclerListlabeltext.adapter = listlabeltextAdapter
//    listlabeltextAdapter.setOnItemClickListener(
//    object : ListlabeltextAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : ListlabeltextRowModel) {
//        onClickRecyclerListlabeltext(view, position, item)
//      }
//    }
//    )
//    viewModel.listlabeltextList.observe(this) {
//      listlabeltextAdapter.updateData(it)
//    }
        binding.signUpScreenZeroVM = viewModel

        // Inside activity
        val stateOfOriginMenu: AutoCompleteTextView = binding.stateOfOriginAuto

        val json = readJsonFromAssets(this, "ng.states.json")
//        Log.v(LOG_TAG, "json: $json")

        val stateList: List<State> = Gson().fromJson(json, States::class.java).states
        Log.v(LOG_TAG, "stateList: $stateList")

        val stateAdapter = StateAdapter(this, R.layout.state_item, stateList) { selectedState ->
            TODO("Filter LGA here?")
//            val lga =
        }
        stateOfOriginMenu.setAdapter(stateAdapter)
        stateAdapter.notifyDataSetChanged()
    }

    override fun setUpClicks(): Unit {
        binding.btnSignUp.setOnClickListener {
            val destIntent = SignUpScreenSevenActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    fun onClickRecyclerListlabeltext(
        view: View,
        position: Int,
        item: ListlabeltextRowModel
    ): Unit {
        when (view.id) {
        }
    }

    companion object {
        const val TAG: String = "SIGN_UP_SCREEN_ZERO_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, SignUpScreenZeroActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }

        fun readJsonFromAssets(context: Context, fileName: String): String {
            return context.assets.open(fileName).bufferedReader().use { it.readText() }
        }

    }
}
