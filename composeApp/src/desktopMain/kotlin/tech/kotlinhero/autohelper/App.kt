package tech.kotlinhero.autohelper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.EventNote
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview


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

@Preview
@Composable
fun App() {
    val navController = rememberNavController()

    LaunchedEffect( Unit) {

    }

    MaterialTheme {
        Scaffold {
            NavigationRail {
                Route.entries.forEach {
                    NavigationRailItem(
                        icon = {
                            Icon(it.icon, contentDescription = it.description)
                        },
                        label = {
                            Text(it.description)
                        },
                        selected = it == Route.Home,
                        onClick = {
//                            navController.navigate(it.path)
                        }
                    )
                }
            }
            NavHost(navController = navController, startDestination = Route.Home.path) {

            }
        }
    }
}
