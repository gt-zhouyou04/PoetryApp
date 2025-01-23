package com.example.poetryapp.fragment

import android.os.Bundle
import android.view.View
import com.example.poetryapp.base.BaseBindingFragment
import com.example.poetryapp.databinding.FragmentMainBinding


class HomeFragment: BaseBindingFragment<FragmentMainBinding>({ FragmentMainBinding.inflate(it) }) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}