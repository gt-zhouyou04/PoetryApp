package com.example.poetryapp.activity

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.poetryapp.base.BaseBindingActivity
import com.example.poetryapp.base.CommPagerAdapter
import com.example.poetryapp.databinding.ActivityMainBinding
import com.example.poetryapp.fragment.MainFragment

class MainActivity : BaseBindingActivity<ActivityMainBinding>({ActivityMainBinding.inflate(it)}) {
    private var pagerAdapter: CommPagerAdapter? = null
    private val fragments = ArrayList<Fragment>()
    private val mainFragment = MainFragment()


    /** 上次点击返回键时间  */
    private var lastTime: Long = 0

    /** 连续按返回键退出时间  */
    private val EXIT_TIME = 2000

    override fun init() {
        fragments.add(mainFragment)
        pagerAdapter = CommPagerAdapter(supportFragmentManager, fragments, arrayOf("", ""))
        binding.viewPager.adapter = pagerAdapter

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                curMainPage = position
                if (position == 0) {
                    Toast.makeText(applicationContext, "继续播放", Toast.LENGTH_SHORT).show()
                } else if (position == 1) {
                    Toast.makeText(applicationContext, "暂停播放", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    override fun onBackPressed() {
        //双击返回退出App
        if (System.currentTimeMillis() - lastTime > EXIT_TIME) {
            if (binding.viewPager.currentItem == 1) {
                binding.viewPager.currentItem = 0
            } else {
                Toast.makeText(applicationContext, "再按一次退出", Toast.LENGTH_SHORT).show()
                lastTime = System.currentTimeMillis()
            }
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        var curMainPage = 0
    }
}