package com.victorvgc.templateapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.victorvgc.templateapp.databinding.TabFavoritesBinding
import com.victorvgc.templateapp.databinding.TabHomeBinding

class FavoritesFragment: Fragment() {
    companion object {

        private var instance: FavoritesFragment? = null
        fun getInstance(): FavoritesFragment {
            if (instance == null) {
                instance = FavoritesFragment()
            }

            return instance!!
        }
    }

    private lateinit var binding: TabFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TabFavoritesBinding.inflate(inflater, container, false)

        return binding.root
    }
}