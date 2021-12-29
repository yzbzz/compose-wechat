package com.yzbzz.wechat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yzbzz.wechat.data.Chat
import com.yzbzz.wechat.data.Message
import com.yzbzz.wechat.data.User
import com.yzbzz.wechat.ui.theme.WeChatTheme

class WeViewModel : ViewModel() {

    var chats by mutableStateOf(
        listOf(
            Chat(
                friend = User("libai", "李白", R.drawable.avatar_libai),
                mutableStateListOf(
                    Message(
                        User("libai", "李白", R.drawable.avatar_libai),
                        "锄禾日当午",
                        "14:20"
                    ),
                    Message(User.Me, "汗滴禾下土", "14:20"),
                    Message(
                        User("libai", "李白", R.drawable.avatar_libai),
                        "谁知盘中餐",
                        "14:20"
                    ),
                    Message(User.Me, "粒粒皆辛苦", "14:20"),
                    Message(
                        User("libai", "李白", R.drawable.avatar_libai),
                        "晚上开黑",
                        "14:20"
                    ),
                    Message(User.Me, "带我飞", "14:20"),
                    Message(
                        User("libai", "李白", R.drawable.avatar_libai),
                        "OK",
                        "14:20"
                    ),
                    Message(User.Me, "OK", "14:20"),
                )
            ),
            Chat(
                friend = User("dufu", "杜甫", R.drawable.avatar_dufu),
                mutableStateListOf(
                    Message(User("dufu", "杜甫", R.drawable.avatar_dufu), "哈哈哈", "13:48"),
                    Message(User.Me, "你哈哈", "13:48"),
                    Message(
                        User("dufu", "杜甫", R.drawable.avatar_dufu),
                        "穷xx",
                        "13:48"
                    ).apply { read = false },
                    Message(User.Me, "哈哈哈哈哈哈哈", "13:48"),
                    Message(
                        User("dufu", "杜甫", R.drawable.avatar_dufu),
                        "xxxxxxx",
                        "13:48"
                    ).apply { read = false },
                )
            ),
        )
    )

    val contacts by mutableStateOf(
        listOf(
            User("libai", "李白", R.drawable.avatar_libai),
            User("dufu", "杜甫", R.drawable.avatar_dufu)
        )
    )

    var selectedTab by mutableStateOf(0)
    var theme by mutableStateOf(WeChatTheme.Theme.Light)
    var currentChat: Chat? by mutableStateOf(null)
    var chatting by mutableStateOf(false)

    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun endChat(): Boolean {
        if (chatting) {
            chatting = false
            return true
        }
        return false
    }

    fun boom(chat: Chat) {
        chat.msgs.add(Message(User.Me, "\uD83D\uDcA3", "15:09").apply { read = true })
    }

}