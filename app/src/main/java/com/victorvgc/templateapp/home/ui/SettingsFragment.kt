package com.victorvgc.templateapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.victorvgc.templateapp.databinding.TabHomeBinding
import com.victorvgc.templateapp.databinding.TabSettingsBinding

class SettingsFragment: Fragment() {
    companion object {

        private var instance: SettingsFragment? = null
        fun getInstance(): SettingsFragment {
            if (instance == null) {
                instance = SettingsFragment()
            }

            return instance!!
        }
    }

    private lateinit var binding: TabSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TabSettingsBinding.inflate(inflater, container, false)

        return binding.root
    }
}