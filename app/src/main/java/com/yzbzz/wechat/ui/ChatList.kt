package com.yzbzz.wechat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yzbzz.wechat.WeViewModel
import com.yzbzz.wechat.data.Chat
import com.yzbzz.wechat.ui.theme.WeChatTheme

@Composable
fun ChatList(chats: List<Chat>) {

    Column(
        Modifier
            .background(WeChatTheme.colors.background)
            .fillMaxSize()
    ) {
        WeTopBar(title = "微信")
        LazyColumn(Modifier.background(WeChatTheme.colors.listItem)) {
            itemsIndexed(chats) { index, chat ->
                ChatListItem(chat)
                if (index < chats.lastIndex) {
                    Divider(
                        startIndent = 68.dp,
                        color = WeChatTheme.colors.chatListDivider,
                        thickness = 0.8f.dp
                    )
                }
            }
        }
    }

}

@Composable
fun ChatListItem(chat: Chat) {
    val viewModel: WeViewModel = viewModel()
    Row(
        Modifier
            .clickable {
                viewModel.startChat(chat)
            }
            .fillMaxWidth()) {
        Image(
            painterResource(chat.friend.avatar), chat.friend.name,
            Modifier
                .padding(4.dp)
                .size(48.dp)
                .unread(!chat.msgs.last().read, WeChatTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                chat.friend.name,
                fontSize = 17.sp,
                color = WeChatTheme.colors.textPrimary
            )
            Text(
                chat.msgs.last().text,
                fontSize = 14.sp,
                color = WeChatTheme.colors.textSecondary
            )
        }
        Text(
            chat.msgs.last().time, Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeChatTheme.colors.textSecondary
        )
    }
}

fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(
            color,
            5.dp.toPx(),
            Offset(size.width - 1.dp.toPx(), 1.dp.toPx())
        )
    }
}