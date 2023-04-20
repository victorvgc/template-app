package com.victorvgc.templateapp.home.ui.list

import com.victorvgc.templateapp.R
import com.victorvgc.templateapp.core.ui.list.BaseAdapter
import com.victorvgc.templateapp.home.domain.model.HomeItem

class HomeAdapter(list: List<HomeItem>) : BaseAdapter<HomeItem>(R.layout.item_template, initialList = list) {}