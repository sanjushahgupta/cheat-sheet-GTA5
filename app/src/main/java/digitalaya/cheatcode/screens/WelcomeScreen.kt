package digitalaya.cheatcode.screens

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import digitalaya.cheatcode.R
import digitalaya.cheatcode.UserPreference
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun WelcomeScreen(navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = UserPreference(context)
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.ic_launcher_foreground_gtaa), contentDescription = "")
    var status = remember{ mutableStateOf(false) }
    scope.launch {
        dataStore.platformIndexStatus.collect {
            val platform = it.toString()
            async {
                delay(700)

              if(platform == "PlayStation" ||platform == "Xbox" || platform =="PC" ||platform == "Phone"){
                    navController.navigate("$platform")
                }else{
                    status.value = true
                }
            }.await()

        }
    }



            if (status.value == true) {
                PopupWindowDialogWelcome(navController)
            }

        }
}
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PopupWindowDialogWelcome(navController: NavController) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val dataStore = UserPreference(context)


        Card(
            elevation = 20.dp,
            shape = RoundedCornerShape(21.dp),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(10.dp)

        ) {
            val gamesOption = listOf("PlayStation", "Xbox", "PC", "Phone")
            val (selectedOptions, onOptionsSelected) = remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .width(400.dp)
                    .wrapContentHeight()
                    .background(colorResource(id = R.color.GTABAC))
                    .padding(20.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                gamesOption.forEach { text ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(selected = (text == selectedOptions),
                                onClick = {
                                    onOptionsSelected(text)
                                    navController.navigate(text)
                                })
                            .padding(16.dp)
                    ) {

                        val context = LocalContext.current
                        RadioButton(selected = (text == selectedOptions), onClick = {
                            onOptionsSelected(text)

                            navController.navigate(text)
                            scope.launch {
                                dataStore.savePlatformIndexStatus(text)
                            }
                        },colors = RadioButtonDefaults.colors(unselectedColor = Color.White)
                        )
                        Text(text = text, modifier = Modifier.padding(10.dp), color = Color.White)

                    }

                }

            }
        }

}
