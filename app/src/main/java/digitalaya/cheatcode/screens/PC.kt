package digitalaya.cheatcode.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import digitalaya.cheatcode.PopupWindowDialog
import digitalaya.cheatcode.R

@Composable
fun PC(navController: NavController) {
var modifier = Modifier
    val popUpState = remember { mutableStateOf(false) }
    Scaffold(topBar = {
        TopAppBar(modifier.fillMaxWidth()) {
            Text(text = "Cheats for GTA5")
            Spacer(modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                contentDescription = "", modifier.clickable(
                    MutableInteractionSource(),
                    indication = null,
                    onClick = { popUpState.value = true }))


        }
    }) {
        Box(modifier.fillMaxSize().padding(20.dp).clickable(
            MutableInteractionSource(),
            indication = null,
            onClick = { popUpState.value = false })
            .fillMaxSize()){
            Text("PC")
            if(popUpState.value){
                PopupWindowDialog(navController)
            }

        }


    }

}
