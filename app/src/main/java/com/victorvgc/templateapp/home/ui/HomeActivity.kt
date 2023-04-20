package com.victorvgc.templateapp.home.ui

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
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

        switchFragment(HomeFragment.getInstance())

        initListeners()

        handleOnBackPressed()
    }

    private fun initListeners() {
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {

                R.id.menu_home -> {
                    switchFragment(HomeFragment.getInstance())
                }
                R.id.menu_favorites -> {
                    switchFragment(FavoritesFragment.getInstance())
                }
                R.id.menu_settings -> {
                    switchFragment(SettingsFragment.getInstance())
                }
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun switchFragment(fragment: Fragment) {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.home_fragment_container, fragment)
        transaction.addToBackStack(null)

        transaction.commit()
    }

    private fun handleOnBackPressed() {
        onBackPressedDispatcher.addCallback(this) {
            finish()
        }
    }
}