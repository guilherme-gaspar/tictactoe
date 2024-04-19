package com.guilhermegaspar.tictactoe

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OldViewModel : ViewModel() {


    private val _state = MutableStateFlow(StateOldMain())
    val state: StateFlow<StateOldMain>
        get() = _state

    fun changeText(firstPosition: Int, lastPosition: Int) {

        val currentText = _state.value.array[firstPosition][lastPosition]
        val newText = if (currentText == "0") "X" else "0"


        val currentList = _state.value.array
        val firstMutableList = currentList.toMutableList()
        val firstList = currentList[firstPosition]
        val mutableList = firstList.toMutableList()
        mutableList.removeAt(lastPosition)
        mutableList.add(lastPosition, newText)
        firstMutableList.add(firstPosition, mutableList)

        _state.value = StateOldMain(firstMutableList)

        Log.i(
            "TesteTicTacToe",
            "Current - $currentText - New - $newText - " +
                    "StateNew - ${_state.value.array[firstPosition][lastPosition]} - " +
                    "FirstPosition $firstPosition - LastPosition $lastPosition"
        )
    }

    val list = listOf(
        listOf("123", "123", "123"),
        listOf("123", "123", "123"),
        listOf(
            "123", "123", "123"
        )
    )

}

data class StateOldMain(
    val array: List<List<String>> = Array(3) { Array(3) { "" }.toList() }.toList()
)