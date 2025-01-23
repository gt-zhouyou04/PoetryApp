package com.example.poetryapp.activity

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.poetryapp.base.BaseBindingActivity
import com.example.poetryapp.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>({ActivityMainBinding.inflate(it)}) {
    private val fragments = ArrayList<Fragment>()
    private val mainFragment = MainFragment()


    /** 上次点击返回键时间  */
    private var lastTime: Long = 0

    /** 连续按返回键退出时间  */
    private val EXIT_TIME = 2000

    override fun init() {
        fragments.add(mainFragment)
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

}