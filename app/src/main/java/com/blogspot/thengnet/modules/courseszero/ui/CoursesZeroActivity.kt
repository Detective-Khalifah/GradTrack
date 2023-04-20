package com.blogspot.thengnet.modules.courseszero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blogspot.thengnet.R
import com.blogspot.thengnet.appcomponents.base.BaseActivity
import com.blogspot.thengnet.databinding.ActivityCoursesZeroBinding
import com.blogspot.thengnet.modules.courses0n.ui.Courses0nActivity
import com.blogspot.thengnet.modules.courseszero.`data`.model.CoursesZeroRowModel
import com.blogspot.thengnet.modules.courseszero.`data`.viewmodel.CoursesZeroVM
import com.blogspot.thengnet.modules.profilezero.ui.ProfileZeroActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class CoursesZeroActivity : BaseActivity<ActivityCoursesZeroBinding>(R.layout.activity_courses_zero)
    {
  private val viewModel: CoursesZeroVM by viewModels<CoursesZeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val coursesZeroAdapter =
    CoursesZeroAdapter(viewModel.coursesZeroList.value?:mutableListOf())
    binding.recyclerCoursesZero.adapter = coursesZeroAdapter
    coursesZeroAdapter.setOnItemClickListener(
    object : CoursesZeroAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : CoursesZeroRowModel) {
        onClickRecyclerCoursesZero(view, position, item)
      }
    }
    )
    viewModel.coursesZeroList.observe(this) {
      coursesZeroAdapter.updateData(it)
    }
    binding.coursesZeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearMaterialYouTa2.setOnClickListener {
      val destIntent = ProfileZeroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerCoursesZero(
    view: View,
    position: Int,
    item: CoursesZeroRowModel
  ): Unit {
    when(view.id) {
      R.id.linearHorizontalcard -> {
        val destIntent = Courses0nActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "COURSES_ZERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CoursesZeroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
