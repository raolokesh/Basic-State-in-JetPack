package com.lokesh.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lokesh.basicstatecodelab.screen.StatefulCounter
import com.lokesh.basicstatecodelab.ui.theme.BasicStateCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                   WellnessScreen()
//                    StatefulCounter()
                    WellnessScreenMain()
                }
            }
        }
    }
}

@Composable
fun WellnessScreenMain(modifier: Modifier = Modifier,
                       wellnessViewModel: WellnessViewModel = viewModel()) {
    Column(modifier = modifier) {
        StatefulCounter()
//        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },onCloseTask = { task -> wellnessViewModel.remove(task) })
    }
}


