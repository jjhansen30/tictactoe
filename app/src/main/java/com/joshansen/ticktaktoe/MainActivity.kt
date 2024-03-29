package com.joshansen.ticktaktoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshansen.ticktaktoe.ui.theme.TickTakToeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TickTakToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TTTScreen()
                }
            }
        }
    }
}

@Composable
fun TTTScreen() {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(24.dp)
    ) {
        Header()
        TurnOrderDisplay()
    }
}

@Composable
fun Header(fontSize: TextUnit = 24.sp) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = fontSize,
        text = stringResource(R.string.app_name)
    )
}

@Composable
fun TurnOrderDisplay(
    viewModel: TTTViewModel = viewModel(),
    padding: Dp = 24.dp,
    background: Int = 0,
    color: Int = 1
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        PlayerTurn(
            player = "Player",
            backGround = viewModel.playerTurnIndicator[background],
            color = viewModel.playerTurnIndicator[color]
        )
        PlayerTurn(
            player = "    AI    ",
            backGround = viewModel.aiTurnIndicator[background],
            color = viewModel.aiTurnIndicator[color]
        )
    }
}

@Composable
fun PlayerTurn(
    player: String,
    backGround: Color,
    color: Color,
    fontSize: TextUnit = 16.sp,
    startPadding: Dp = 20.dp,
    endPadding: Dp = 20.dp,
    topPadding: Dp = 4.dp,
    bottomPadding: Dp = 4.dp
) {
    Text(
        modifier = Modifier
            .background(backGround)
            .padding(
                start = startPadding,
                end = endPadding,
                top = topPadding,
                bottom = bottomPadding
            ),
        color = color,
        fontSize = fontSize,
        text = player
    )
}

@Preview
@Composable
fun TTTPreview() {
    TTTScreen()
}