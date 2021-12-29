package com.yzbzz.wechat

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AccountActivity : ComponentActivity() {

    private var number by mutableStateOf("10010")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_manage)
        initView()
    }

    private fun initView() {
        findViewById<TextView>(R.id.tv_jump).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<TextView>(R.id.tv_change).setOnClickListener {
            number = when (number) {
                "10010" -> {
                    "10086"
                }
                "10086" -> {
                    "12315"
                }
                "12315" -> {
                    "10010"
                }
                else -> {
                    "10010"
                }
            }
        }


        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            SetComposeContentView()
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun SetComposeContentView() {
        Column {
            Text(
                modifier = Modifier
                    .padding(16.dp, 16.dp, 0.dp, 8.dp),
                text = stringResource(R.string.home_main_account),
                fontSize = 14.sp,
                color = colorResource(R.color.c73000000)
            )
            Row(
                Modifier
                    .background(Color.White)
                    .padding(32.dp, 12.dp, 18.dp, 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.home_phone_pwd_reset), fontSize = 12.sp,
                        color = colorResource(R.color.c73000000),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = number, fontSize = 16.sp)
                }
                Spacer(Modifier.weight(1f))
                Image(
                    modifier = Modifier.size(24.dp, 24.dp),
                    painter = painterResource(id = R.drawable.ic_pwd_reset),
                    contentDescription = "Contact profile picture",
                )
            }
        }
    }
}


