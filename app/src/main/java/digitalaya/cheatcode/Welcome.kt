package digitalaya.cheatcode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Welcome(navController: NavController) {

   Scaffold(topBar = {
    TopAppBar(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Cheats for GTA 5")
        Spacer(Modifier.weight(1f))
           Icon(
               painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                contentDescription = "setting"
            )
        }
    }) {

val popUp = remember {
    mutableStateOf(true)
}
        Box(
            modifier = Modifier
                .padding(20.dp)
                .clickable(
                    MutableInteractionSource(),
            indication = null,
            onClick = { popUp.value = false })
                .fillMaxSize(), Alignment.Center

        ) {
            if(popUp.value){
               PopupWindowDialog(navController)
            }

        }
   }


}

@Composable
fun PopupWindowDialog(navController: NavController) {

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
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            gamesOption.forEach { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(selected = (text == selectedOptions),
                            onClick = { onOptionsSelected(text)
                                navController.navigate("$text")})
                        .padding(16.dp)
                ) {

                    val context = LocalContext.current
                    RadioButton(selected = (text == selectedOptions), onClick = {
                        onOptionsSelected(text)
                        navController.navigate("$text")
                    })
                    Text(text = text, modifier = Modifier.padding(10.dp))

                }

            }
        }
    }


}
