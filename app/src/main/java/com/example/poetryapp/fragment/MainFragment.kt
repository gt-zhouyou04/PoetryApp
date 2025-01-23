package com.example.poetryapp.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.poetryapp.base.BaseBindingFragment
import com.example.poetryapp.base.CommPagerAdapter
import com.example.poetryapp.databinding.FragmentMainBinding
import java.util.ArrayList

class MainFragment : BaseBindingFragment<FragmentMainBinding>({ FragmentMainBinding.inflate(it) }) {
    private var recommendFragment: RecommendFragment? = null

    private val fragments = ArrayList<Fragment>()
    private var pagerAdapter: CommPagerAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragments()
        setBottomMenu()
    }

    private fun setFragments() {
        recommendFragment = RecommendFragment()
        fragments.add(recommendFragment!!)
        setTopMenu()
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                curPage = position
                if (position == 1) {
                    //继续播放
                    Toast.makeText(context, "当前首页", Toast.LENGTH_SHORT).show()
                } else {
                    //切换到其他页面，需要暂停视频
                    Toast.makeText(context, "切换到其他页面", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setBottomMenu() {
        val titles = arrayOf("首页", "ai", "", "创作中心", "我")

        // Create a new TableRow
        val tableRow = TableRow(this.context).apply {
            layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        }

        // Loop through titles and add TextViews to the TableRow
        for (title in titles) {
            val textView = TextView(this.context).apply {
                text = title
                gravity = Gravity.CENTER
                setTextColor(Color.WHITE)  // Set text color to white
                layoutParams = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            }
            tableRow.addView(textView)
        }

        // Add the TableRow to the TableLayout
        binding.bottomTab.addView(tableRow)
    }

    private fun setTopMenu() {
        val titles = arrayOf("推荐", "社区", "分类")

        // Create a new TableRow
        val tableRow = TableRow(this.context).apply {
            layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        }

        // Loop through titles and add TextViews to the TableRow
        for (title in titles) {
            val textView = TextView(this.context).apply {
                text = title
                gravity = Gravity.CENTER
                setTextColor(Color.WHITE)  // Set text color to white
                layoutParams = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            }
            tableRow.addView(textView)
        }

        // Add the TableRow to the TableLayout
        binding.topTab.addView(tableRow)
    }



    companion object {
        /** 默认显示第一页推荐页  */
        var curPage = 1
    }
}