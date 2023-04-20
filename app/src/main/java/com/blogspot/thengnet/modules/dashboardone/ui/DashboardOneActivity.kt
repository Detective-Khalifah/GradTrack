package com.blogspot.thengnet.modules.dashboardone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityDashboardOneBinding
import com.blogspot.thengnet.modules.courseszero.ui.CoursesZeroActivity
import com.blogspot.thengnet.modules.dashboardone.`data`.model.Coursescards1RowModel
import com.blogspot.thengnet.modules.dashboardone.`data`.model.Listinitial1RowModel
import com.blogspot.thengnet.modules.dashboardone.`data`.viewmodel.DashboardOneVM
import com.blogspot.thengnet.modules.dashboardzero.ui.DashboardZeroActivity
import com.blogspot.thengnet.modules.profilezero.ui.ProfileZeroActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DashboardOneActivity :
    BaseActivity<ActivityDashboardOneBinding>(R.layout.activity_dashboard_one) {
  private val viewModel: DashboardOneVM by viewModels<DashboardOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val coursesCardsAdapter =
    CoursesCardsAdapter(viewModel.coursesCardsList.value?:mutableListOf())
    binding.recyclerCoursesCards.adapter = coursesCardsAdapter
    coursesCardsAdapter.setOnItemClickListener(
    object : CoursesCardsAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Coursescards1RowModel) {
        onClickRecyclerCoursesCards(view, position, item)
      }
    }
    )
    viewModel.coursesCardsList.observe(this) {
      coursesCardsAdapter.updateData(it)
    }
    val listinitialAdapter =
    ListinitialAdapter(viewModel.listinitialList.value?:mutableListOf())
    binding.recyclerListinitial.adapter = listinitialAdapter
    listinitialAdapter.setOnItemClickListener(
    object : ListinitialAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listinitial1RowModel) {
        onClickRecyclerListinitial(view, position, item)
      }
    }
    )
    viewModel.listinitialList.observe(this) {
      listinitialAdapter.updateData(it)
    }
    binding.dashboardOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtViewDetailsOne.setOnClickListener {
      val destIntent = CoursesZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearMaterialYouTa2.setOnClickListener {
      val destIntent = ProfileZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearViewdetails.setOnClickListener {
      val destIntent = DashboardZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtViewDetails.setOnClickListener {
      val destIntent = CoursesZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerCoursesCards(
    view: View,
    position: Int,
    item: Coursescards1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListinitial(
    view: View,
    position: Int,
    item: Listinitial1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DASHBOARD_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DashboardOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
