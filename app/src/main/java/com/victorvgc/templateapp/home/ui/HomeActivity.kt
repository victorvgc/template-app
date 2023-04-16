package com.victorvgc.templateapp.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.victorvgc.templateapp.R
import com.victorvgc.templateapp.core.ui.BaseActivity
import com.victorvgc.templateapp.databinding.ActivityHomeBinding
import com.victorvgc.templateapp.home.ui.view_model.HomeViewModel

class HomeActivity : BaseActivity() {
    override val viewModel: HomeViewModel by viewModels()

    private val binding: ActivityHomeBinding by binding(R.layout.activity_home)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.apply {
            lifecycleOwner = this@HomeActivity
        }
    }
}