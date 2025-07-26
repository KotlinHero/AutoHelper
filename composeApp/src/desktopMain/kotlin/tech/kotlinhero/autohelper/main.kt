package tech.kotlinhero.autohelper

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "任务助手",
    ) {
        App()
    }
}