package com.joshansen.ticktaktoe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TTTViewModel @Inject constructor():ViewModel() {

    private val isPlayerTurn: MutableState<Boolean> = mutableStateOf(true)
    val playerTurnIndicator: MutableList<Color> = mutableListOf(Color.Blue, Color.White)
    val aiTurnIndicator: MutableList<Color> = mutableListOf(Color.LightGray, Color.Black)

    fun setTurnDisplay() {
        when(isPlayerTurn.value) {
            true -> {
                playerTurnIndicator[0] = Color.Blue
                playerTurnIndicator[1] = Color.White
                aiTurnIndicator[0] = Color.LightGray
                aiTurnIndicator[1] = Color.Black
            }
            false -> {
                playerTurnIndicator[0] = Color.LightGray
                playerTurnIndicator[1] = Color.Black
                aiTurnIndicator[0] = Color.Red
                aiTurnIndicator[1] = Color.Black
            }
        }
    }

    fun nextTurn() {
        isPlayerTurn.value = !isPlayerTurn.value
    }
}