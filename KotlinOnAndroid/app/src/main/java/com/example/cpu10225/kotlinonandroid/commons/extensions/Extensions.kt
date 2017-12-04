@file:JvmName("ExtensionsUtils")

package com.example.cpu10225.kotlinonandroid.commons.extensions

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.cpu10225.kotlinonandroid.R
import com.squareup.picasso.Picasso

/**
 * Created by cpu10225 on 01/12/2017.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    }
    else {
        Picasso.with(context).load(imageUrl).into(this)
    }
}