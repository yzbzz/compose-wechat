package com.yzbzz.wechat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yzbzz.wechat.R
import com.yzbzz.wechat.WeViewModel
import com.yzbzz.wechat.ui.theme.WeChatTheme

@Composable
fun WeTopBar(title: String, onBack: (() -> Unit)? = null) {
    Box(
        Modifier
            .background(WeChatTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .height(48.dp)
        ) {
            if (onBack != null) {
                Icon(
                    painterResource(R.drawable.ic_back),
                    null,
                    Modifier
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = WeChatTheme.colors.icon
                )
            }
            Spacer(Modifier.weight(1f))
            val viewModel: WeViewModel = viewModel()
            Icon(
                painterResource(R.drawable.ic_palette),
                "切换主题",
                Modifier
                    .clickable {
                        viewModel.theme = when (viewModel.theme) {
                            WeChatTheme.Theme.Light -> WeChatTheme.Theme.Dark
                            WeChatTheme.Theme.Dark -> WeChatTheme.Theme.NewYear
                            WeChatTheme.Theme.NewYear -> WeChatTheme.Theme.Light
                        }
                    }
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = WeChatTheme.colors.icon
            )
        }
        Text(title, Modifier.align(Alignment.Center), color = WeChatTheme.colors.textPrimary)
    }
}