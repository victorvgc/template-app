package com.victorvgc.templateapp.core.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.victorvgc.templateapp.BR
import com.victorvgc.templateapp.core.extensions.setOnceClickListener

open class BaseAdapter<T>(
    @LayoutRes val layoutId: Int,
    private val listener: ((T, position: Int) -> Unit)? = null,
    initialList: List<T>? = null
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<T>>() {

    protected val itemList = mutableListOf<T>()

    init {
        if (initialList != null) {
            setupItems(initialList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutId, parent, false
        )
        return BaseViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) =
        holder.bind(itemList[position], position)

    @SuppressLint("NotifyDataSetChanged")
    fun setupItems(items: List<T>) {
        this.itemList.clear()
        this.itemList.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: T,  position: Int = -1) {
        if (position == -1) {
            this.itemList.add(item)
            notifyItemInserted(this.itemList.size)
        }  else {
            this.itemList.add(position, item)
            notifyItemInserted(position)
        }
    }

    fun removeItemAt(position: Int) {
        this.itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItemAt(item: T, position: Int) {
        this.itemList[position] = item
        notifyItemChanged(position)
    }

    open class BaseViewHolder<T>(
        private val binding: ViewDataBinding,
        private val listener: ((T, position: Int) -> Unit)? = null
    ) : RecyclerView.ViewHolder(binding.root) {

        open fun bind(item: T, position: Int) {
            binding.setVariable(BR.item, item)
            itemView.setOnceClickListener { listener?.invoke(item, position) }
            binding.executePendingBindings()
        }
    }
}