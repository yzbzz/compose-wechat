package com.yzbzz.wechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import com.yzbzz.wechat.ui.ChatPage
import com.yzbzz.wechat.ui.Home
import com.yzbzz.wechat.ui.theme.WeChatTheme

class MainActivity : ComponentActivity() {

    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeChatTheme(viewModel.theme) {
                Box {
                    Home(viewModel)
                    ChatPage()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.endChat()) {
            super.onBackPressed()
        }
    }

}


