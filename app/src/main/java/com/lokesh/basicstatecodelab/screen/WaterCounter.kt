package com.lokesh.basicstatecodelab.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
//    var count: MutableState<Int> = remember {
//        mutableIntStateOf(0)
//    }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }
            if (showTask) {
//                WellnessTaskItem(taskName = "You Have take 15 mint Break", onClose = { /*TODO*/ })
            }
            Text(
                text = "You've had ${count} water"

            )
        }
        Row {
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {
                Text(text = "Add One")
            }

            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(top = 8.dp, start = 8.dp)
            ) {
                Text(text = "Clear water Count")
            }
        }


    }

}


@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(
            onClick = { onIncrement() },
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add One")
        }
    }

}

@Preview
@Composable
private fun WaterCounterPreview() {
    WaterCounter()
}

@Composable
fun StatefulCounter() {
    var waterCount by rememberSaveable { mutableStateOf(0) }

    var juiceCount by remember { mutableStateOf(0) }
    Column {
        StatelessCounter(waterCount, { waterCount++ })
//        StatelessCounter(juiceCount, { juiceCount++ })
    }

}