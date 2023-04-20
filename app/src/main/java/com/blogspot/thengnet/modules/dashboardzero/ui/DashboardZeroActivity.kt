package com.blogspot.thengnet.modules.dashboardzero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityDashboardZeroBinding
import com.blogspot.thengnet.modules.courses0n.ui.Courses0nActivity
import com.blogspot.thengnet.modules.courseszero.ui.CoursesZeroActivity
import com.blogspot.thengnet.modules.dashboardone.ui.DashboardOneActivity
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.CoursescardsRowModel
import com.blogspot.thengnet.modules.dashboardzero.`data`.model.ListinitialRowModel
import com.blogspot.thengnet.modules.dashboardzero.`data`.viewmodel.DashboardZeroVM
import com.blogspot.thengnet.modules.profilezero.ui.ProfileZeroActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DashboardZeroActivity :
    BaseActivity<ActivityDashboardZeroBinding>(R.layout.activity_dashboard_zero) {
  private val viewModel: DashboardZeroVM by viewModels<DashboardZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val coursesCardsAdapter =
    CoursesCardsAdapter(viewModel.coursesCardsList.value?:mutableListOf())
    binding.recyclerCoursesCards.adapter = coursesCardsAdapter
    coursesCardsAdapter.setOnItemClickListener(
    object : CoursesCardsAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : CoursescardsRowModel) {
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
      override fun onItemClick(view:View, position:Int, item : ListinitialRowModel) {
        onClickRecyclerListinitial(view, position, item)
      }
    }
    )
    viewModel.listinitialList.observe(this) {
      listinitialAdapter.updateData(it)
    }
    binding.dashboardZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearViewdetails.setOnClickListener {
      val destIntent = DashboardOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtViewDetailsOne.setOnClickListener {
      val destIntent = CoursesZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtViewDetailsTwo.setOnClickListener {
      val destIntent = CoursesZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearMaterialYouTa2.setOnClickListener {
      val destIntent = ProfileZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerCoursesCards(
    view: View,
    position: Int,
    item: CoursescardsRowModel
  ): Unit {
    when(view.id) {
      R.id.linearHorizontalcard -> {
        onClickRecyclerCoursesCardsLinearHorizontalcard(view, position, item)
      }
    }
  }

  fun onClickRecyclerListinitial(
    view: View,
    position: Int,
    item: ListinitialRowModel
  ): Unit {
    when(view.id) {
      R.id.linearHorizontalcard -> {
        val destIntent = Courses0nActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  fun onClickRecyclerCoursesCardsLinearHorizontalcard(
    view: View,
    position: Int,
    item: CoursescardsRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = Courses0nActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = Courses0nActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      2 -> {
        val destIntent = Courses0nActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      3 -> {
        val destIntent = Courses0nActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "DASHBOARD_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DashboardZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
