package digitalaya.grandcodes.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import digitalaya.grandcodes.screens.*
import kotlin.system.exitProcess

@Composable
fun navigationNavController() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Welcome") {

        composable("Welcome") {
            WelcomeScreen(navController = navController)
            BackHandler() {
                exitProcess(1)
            }

        }



        composable("Xbox") {
            Xbox(navController = navController)
            BackHandler() {
                exitProcess(1)
            }
        }

        composable("PlayStation") {
            PlayStation(navController = navController)
            BackHandler() {
                exitProcess(1)
            }
        }

        composable("Phone") {
            Phone(navController = navController)

            BackHandler() {

                exitProcess(1)
            }
        }

        composable("PC") {
            PC(navController = navController)
            BackHandler() {
                exitProcess(1)
            }
        }


    }

}
