package com.guilhermegaspar.tictactoe

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {


    private val _state = MutableStateFlow(StateMain())
    val state: StateFlow<StateMain>
        get() = _state

    fun changeText(position: Int) {
        val currentText = _state.value.array[position]
        val newText = if (currentText == "0") "X" else "0"
        val mutableList = _state.value.array.toMutableList()
        mutableList.removeAt(position)
        mutableList.add(position, newText)
        _state.value = StateMain(mutableList)
        hasWin(newText)
    }

    fun hasWin(text: String) {
        val currentArray = _state.value.array
        if ((currentArray[0] == text && currentArray[1] == text && currentArray[2] == text) ||
            (currentArray[0] == text && currentArray[3] == text && currentArray[6] == text) ||
            (currentArray[0] == text && currentArray[4] == text && currentArray[8] == text) ||
            (currentArray[3] == text && currentArray[4] == text && currentArray[5] == text) ||
            (currentArray[1] == text && currentArray[4] == text && currentArray[7] == text) ||
            (currentArray[6] == text && currentArray[4] == text && currentArray[2] == text) ||
            (currentArray[8] == text && currentArray[5] == text && currentArray[2] == text) ||
            (currentArray[6] == text && currentArray[7] == text && currentArray[8] == text)
        ) {
            _state.value.isWin = true
        }
    }
}

data class StateMain(
    val array: List<String> = Array(9) { "" }.toList(),
    var isWin: Boolean = false
)