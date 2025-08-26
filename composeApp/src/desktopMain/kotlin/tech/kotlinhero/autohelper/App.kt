package tech.kotlinhero.autohelper

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.kotlinhero.autohelper.route.Route


@Preview
@Composable
fun App() {
    val navController = rememberNavController()

    MaterialTheme {
        Row {

        }
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
    }
}
