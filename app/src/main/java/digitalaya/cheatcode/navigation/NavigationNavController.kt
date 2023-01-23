package digitalaya.cheatcode.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import digitalaya.cheatcode.screens.*

@Composable
fun navigationNavController() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Welcome") {

        composable("Welcome") {
            WelcomeScreen(navController = navController)

        }



        composable("Xbox") {
            Xbox(navController = navController)
        }

        composable("PlayStation") {
            PlayStation(navController = navController)
        }

        composable("Phone") {
            Phone(navController = navController)
        }

        composable("PC") {
            PC(navController = navController)
        }


    }

}
