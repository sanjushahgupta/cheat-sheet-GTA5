package digitalaya.cheatcode.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import digitalaya.cheatcode.Welcome
import digitalaya.cheatcode.screens.PC
import digitalaya.cheatcode.screens.Phone
import digitalaya.cheatcode.screens.PlayStation
import digitalaya.cheatcode.screens.Xbox

@Composable
fun navigationNavController(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome"){

        composable("welcome"){
            Welcome(navController = navController)
        }

        composable("PlayStation"){
            PlayStation(navController = navController)
        }

        composable("Phone"){
            Phone(navController = navController)
        }

        composable("PC"){
            PC(navController = navController)
        }

      composable("Xbox"){
          Xbox(navController = navController)
      }

    }

}
