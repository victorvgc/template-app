package com.victorvgc.templateapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorvgc.templateapp.databinding.TabHomeBinding
import com.victorvgc.templateapp.home.domain.model.HomeItem
import com.victorvgc.templateapp.home.ui.list.HomeAdapter

class HomeFragment: Fragment() {
    companion object {

        private var instance: HomeFragment? = null
        fun getInstance(): HomeFragment {
            if (instance == null) {
                instance = HomeFragment()
            }

            return instance!!
        }
    }

    private lateinit var binding: TabHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TabHomeBinding.inflate(inflater, container, false)

        populateList()

        return binding.root
    }

    private fun populateList() {
        val list = listOf(
            HomeItem(
                imgUrl = "https://media.wired.co.uk/photos/60c8730fa81eb7f50b44037e/16:9/w_3332,h_1874,c_limit/1521-WIRED-Cat.jpeg",
                title = "First Item",
                subtitle = "First item subtitle that contains useful info"
            ),
            HomeItem(
                imgUrl = "https://www.daysoftheyear.com/cdn-cgi/image/dpr=1%2Cf=auto%2Cfit=cover%2Cheight=650%2Cq=70%2Csharpen=1%2Cwidth=956/wp-content/uploads/international-cat-day1-scaled.jpg",
                title = "Second Item",
                subtitle = "Second item subtitle that contains useful info"
            ),
            HomeItem(
                imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuHUlP6F15TiQpEK3oo9uzyvk0gFBypWJqAA&usqp=CAU",
                title = "Third Item",
                subtitle = "Third item subtitle that contains useful info"
            ),
            HomeItem(
                imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLzcsV4BFgzJvdrol4epZY3CZ08w2j6OhWBw&usqp=CAU",
                title = "4th Item",
                subtitle = "4th item subtitle that contains useful info"
            ),
            HomeItem(
                imgUrl = "https://i.guim.co.uk/img/media/c5e73ed8e8325d7e79babf8f1ebbd9adc0d95409/2_5_1754_1053/master/1754.jpg?width=1200&quality=85&auto=format&fit=max&s=4219f64fafe19d101f92e0eba0181f6a",
                title = "5th Item",
                subtitle = "5th item subtitle that contains useful info"
            ),
            HomeItem(
                imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqZ4WyuZGOlUKWb_gQgGYks__E0s8BmmSNJw&usqp=CAU",
                title = "6th Item",
                subtitle = "6th item subtitle that contains useful info"
            ),
            HomeItem(
                imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4ym7NPo_RIL5WYAl6lElRDAZRr_WwOR-hkw&usqp=CAU",
                title = "7th Item",
                subtitle = "7th item subtitle that contains useful info"
            ),
        )

        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())

        binding.rvHome.adapter = HomeAdapter(list)
    }
}