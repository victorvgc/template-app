package com.victorvgc.templateapp.core.extensions

import android.os.SystemClock
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.victorvgc.templateapp.R

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

@BindingAdapter("bindUrl")
fun ImageView.bindUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .error(R.drawable.baseline_broken_image_24)
        .into(this)
}

fun View.setOnceClickListener(debounceTime: Long = 600L, action: (view: View) -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action(v)

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}