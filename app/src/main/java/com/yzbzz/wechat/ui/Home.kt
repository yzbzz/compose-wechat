package com.yzbzz.wechat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.yzbzz.wechat.WeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(viewModel: WeViewModel) {
    Column {
        val pagerState = rememberPagerState()
        HorizontalPager(count = 4, Modifier.weight(1f), pagerState) { page ->
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> ContactList()
                2 -> DiscoveryList()
                3 -> MeList()

            }
        }
        val scope = rememberCoroutineScope()
        WeBottomBar(pagerState.currentPage) { page ->
            scope.launch {
                pagerState.animateScrollToPage(page)
            }
        }
    }
}