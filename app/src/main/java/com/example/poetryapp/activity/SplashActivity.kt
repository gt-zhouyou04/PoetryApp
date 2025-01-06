package com.example.poetryapp.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.poetryapp.MainActivity
import com.example.poetryapp.R
import com.example.poetryapp.base.BaseBindingActivity
import com.example.poetryapp.databinding.ActivitySplashBinding
import com.example.poetryapp.mock.DataCreate

class SplashActivity : BaseBindingActivity<ActivitySplashBinding>({ ActivitySplashBinding.inflate(it) }) {

    override fun init() {
        setFullScreen()
        DataCreate()

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.imageViewSplash.startAnimation(fadeIn)

        object : CountDownTimer(3000, 3000) {  // 3 seconds for duration, 500 ms for interval
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val fadeOut = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.fade_out)
                fadeOut.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}

                    override fun onAnimationEnd(animation: Animation) {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                        finish()
                    }

                    override fun onAnimationRepeat(animation: Animation) {}
                })
                binding.imageViewSplash.startAnimation(fadeOut)
            }
        }.start()
    }
}
