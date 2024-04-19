package com.guilhermegaspar.tictactoe

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guilhermegaspar.tictactoe.ui.theme.TictactoeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TictactoeTheme {

                val viewModel: MainViewModel = viewModel()
                val state = viewModel.state.collectAsState()
                val array = state.value.array


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Button(onClick = {
                                    viewModel.changeText(0)
                                }) {
                                    Text(text = array[0])
                                }
                                Button(onClick = {
                                    viewModel.changeText(1)
                                }) {
                                    Text(text = array[1])
                                }
                                Button(onClick = {
                                    viewModel.changeText(2)
                                }) {
                                    Text(text = array[2])
                                }
                            }
                            Column(modifier = Modifier.padding(8.dp)) {
                                Button(onClick = {
                                    viewModel.changeText(3)
                                }) {
                                    Text(text = array[3])
                                }
                                Button(onClick = {
                                    viewModel.changeText(4)
                                }) {
                                    Text(text = array[4])
                                }
                                Button(onClick = {
                                    viewModel.changeText(5)
                                }) {
                                    Text(text = array[5])
                                }
                            }
                            Column(modifier = Modifier.padding(8.dp)) {
                                Button(onClick = {
                                    viewModel.changeText(6)
                                }) {
                                    Text(text = array[6])
                                }
                                Button(onClick = {
                                    viewModel.changeText(7)
                                }) {
                                    Text(text = array[7])
                                }
                                Button(onClick = {
                                    viewModel.changeText(8)
                                }) {
                                    Text(text = array[8])
                                }
                            }
                            if (state.value.isWin) {
                                Text("Vc venceu")
                            } else {
                                Text("Vc nao venceu")
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TictactoeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {

        }
    }
}