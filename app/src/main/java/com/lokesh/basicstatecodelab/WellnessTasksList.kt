package com.lokesh.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lokesh.basicstatecodelab.screen.WellnessTaskItem


//
//
//@Composable
//fun WellnessTasksList(
//    modifier: Modifier = Modifier,
//    list: List<WellnessTask> = remember { getWellnessTasks() },
//    onClose:()->Unit
//) {
//    LazyColumn(
//        modifier = modifier
//    ) {
//        items(list) {
//            item ->
//            WellnessTaskItem(taskName = item.label,onClose = onClose)
//        }
//    }
//}
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask : (WellnessTask,Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked.value,
                onCheckedChange = { checked -> onCheckedTask(task, checked)},
                onClose = { onCloseTask(task) })
        }
    }
}