package tech.kotlinhero.autohelper.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.EventNote
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Route(
    val path: String,
    val description: String,
    val icon: ImageVector
) {
    Home("home", "首页", Icons.Default.Home),
    Log("log", "日志", Icons.AutoMirrored.Filled.EventNote),
    Settings("settings", "设置", Icons.Default.Settings),
    Help("help", "帮助", Icons.AutoMirrored.Filled.Help)
}