package digitalaya.cheatcode.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground_gtaa),
            contentDescription = ""
        )
        var status = remember { mutableStateOf(false) }
        val context = LocalContext.current
        scope.launch {
            dataStore.platformIndexStatus.collect {
                val platform = it.toString()

                async {
                    delay(700)

                    if (platform.equals("0")) {
                        navController.navigate("PlayStation")
                    } else if (platform.equals("1")) {
                        navController.navigate("Xbox")
                    } else if (platform.equals("2")) {
                        navController.navigate("PC")
                    } else if (platform.equals("3")) {
                        navController.navigate("Phone")
                    }else{
                        status.value = true
                    }
                     //    Toast.makeText(context, platform, Toast.LENGTH_SHORT).show()

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
                .background(colorResource(id = R.color.teal_200))
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Choose platform", color = Color.White, fontWeight = FontWeight.Bold)

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

                    RadioButton(
                        selected = (text == selectedOptions), onClick = {
                            onOptionsSelected(text)

                            if (text.equals("PlayStation")) {
                                scope.launch {
                                    dataStore.savePlatformIndexStatus("0")
                                }
                                navController.navigate(text)
                            } else if (text.equals("Xbox")) {
                                scope.launch {
                                    dataStore.savePlatformIndexStatus("1")
                                }
                                navController.navigate(text)
                            } else if (text.equals("PC")) {
                                scope.launch {
                                    dataStore.savePlatformIndexStatus("2")
                                }
                                navController.navigate(text)
                            } else if (text.equals("Phone")) {
                                scope.launch {
                                    dataStore.savePlatformIndexStatus("3")
                                }
                                navController.navigate(text)
                            }


                        }, colors = RadioButtonDefaults.colors(unselectedColor = Color.White)
                    )

                  Text(text = text, modifier = Modifier.padding(10.dp), color = Color.White)

                }

            }

        }
    }
}
