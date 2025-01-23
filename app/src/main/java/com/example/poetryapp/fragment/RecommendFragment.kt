package com.example.poetryapp.fragment

import android.os.Bundle
import android.view.View
import com.example.poetryapp.base.BaseBindingFragment
import com.example.poetryapp.databinding.FragmentRecommendBinding

class RecommendFragment: BaseBindingFragment<FragmentRecommendBinding>({ FragmentRecommendBinding.inflate(it) }) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}