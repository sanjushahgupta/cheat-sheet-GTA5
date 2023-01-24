package digitalaya.cheatcode.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.sp
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
            .fillMaxHeight(0.7f)
            .padding(start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.gtalogoo),
            contentDescription = "",

            )
        Text("Cheat codes for GTA 5", color = colorResource(id = R.color.teal_200))
        Spacer(modifier = Modifier.padding(top = 30.dp))
        var status = remember { mutableStateOf(false) }


        scope.launch {
            dataStore.platformIndexStatus.collect {
                val platform = it.toString()

                async {
                    delay(700)

                    if (platform.equals("PlayStation")) {
                        navController.navigate("PlayStation")
                    } else if (platform.equals("Xbox")) {
                        navController.navigate("Xbox")
                    } else if (platform.equals("PC")) {
                        navController.navigate("PC")
                    } else if (platform.equals("Phone")) {
                        navController.navigate("Phone")
                    } else {
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



    Column(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(start = 10.dp, end = 10.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        val gamesOption = listOf("PlayStation", "Xbox", "PC", "Phone")
        val (selectedOptions, onOptionsSelected) = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .width(400.dp)
                .wrapContentHeight()
                .background(
                    colorResource(id = R.color.teal_200), shape = RoundedCornerShape(18.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Select platform",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 17.dp, bottom = 15.dp)
            )

            gamesOption.forEach { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(selected = (text == selectedOptions), onClick = {
                            onOptionsSelected(text)
                            //    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                            scope.launch {
                                dataStore.savePlatformIndexStatus(text)
                                navController.navigate(text)
                            }

                        })

                ) {

                    RadioButton(
                        selected = (text == selectedOptions), onClick = {
                            onOptionsSelected(text)
                        }, colors = RadioButtonDefaults.colors(unselectedColor = Color.White)
                    )

                    Text(
                        text = text,
                        modifier = Modifier.padding(top = 12.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )

                }

            }
            Spacer(modifier = Modifier.padding(bottom = 15.dp))

        }
    }
}
