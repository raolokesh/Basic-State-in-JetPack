package com.lokesh.basicstatecodelab.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun WellnessScreen(modifier:Modifier = Modifier) {
        WaterCounter(modifier)
}

@Preview
@Composable
private fun WellnessScreenPreview() {
    WellnessScreen()
}