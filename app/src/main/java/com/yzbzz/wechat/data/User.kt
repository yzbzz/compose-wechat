package com.yzbzz.wechat.data

import androidx.annotation.DrawableRes
import com.yzbzz.wechat.R

class User(val id: String, val name: String, @DrawableRes val avatar: Int) {
    companion object {
        val Me: User = User("Yzbzz", "Yzbzz", R.drawable.avatar_yzbzz)
    }
}