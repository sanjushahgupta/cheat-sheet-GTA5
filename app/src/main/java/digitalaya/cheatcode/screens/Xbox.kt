package digitalaya.cheatcode.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import digitalaya.cheatcode.PopupWindowDialog
import digitalaya.cheatcode.R


@Composable
fun Xbox(navController: NavController) {
    var modifier = Modifier
    val popUpState = remember { mutableStateOf(false) }
    Scaffold(topBar = {
        TopAppBar(modifier.fillMaxWidth()) {
            Column {
                Text(
                    text = "Cheats for GTA 5",
                    modifier.padding(bottom = 5.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Xbox", modifier.padding(bottom = 5.dp))
            }

            Spacer(modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                contentDescription = "",
                modifier.clickable(MutableInteractionSource(),
                    indication = null,
                    onClick = { popUpState.value = true })
            )

        }
    }) {

        Box(
            modifier
                .fillMaxSize()
                .padding(20.dp)
                .clickable(MutableInteractionSource(),
                    indication = null,
                    onClick = { popUpState.value = false })
                .fillMaxSize()
        ) {

            CheatCodesXbox()
            if (popUpState.value) {
                PopupWindowDialog(navController)
            }

        }


    }
}

@Composable
fun CheatCodesXbox() {

    var xboxList = listOf(
        stringResource(R.string.Invincibility),
        stringResource(R.string.MaxHealthandArmor),
        stringResource(R.string.SuperJump),
        stringResource(R.string.MoonGravity),
        stringResource(R.string.RaiseWantedLevel),
        stringResource(R.string.LowerWantedLevel),
        stringResource(R.string.FastRun),
        stringResource(R.string.FastSwim),
        stringResource(R.string.RechargeAbility),
        stringResource(R.string.Skyfall),
        stringResource(R.string.ExplosiveBullets),
        stringResource(R.string.FlamingBullets),
        stringResource(R.string.SlowMotionAim),
        stringResource(R.string.DrunkMode),
        stringResource(R.string.Weapons),
        stringResource(R.string.GiveParachute),
        stringResource(R.string.SpawnBuzzard),
        stringResource(R.string.SpawnComet),
        stringResource(R.string.SpawnSanchez),
        stringResource(R.string.SpawnTrashmaster),
        stringResource(R.string.SpawnLimo),
        stringResource(R.string.SpawnStuntPlane),
        stringResource(R.string.SpawnCaddy),
        stringResource(R.string.SpawnRapidGT),
        stringResource(R.string.SpawnDuster),
        stringResource(R.string.SpawnPCJ),
        stringResource(R.string.SpawnBMX),
        stringResource(R.string.ChangeWeather),
        stringResource(R.string.SlideyCars),
        stringResource(R.string.SlowMotion)
    )

    val detailsStatus = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(xboxList) { item ->
                Divider()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { detailsStatus.value = true }
                ) {
                    Text(
                        text = item, modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Divider()
            }
        }


    }
}

@Composable
fun popUpdetails(Indexname: String) {
    val context = LocalContext.current

    Card(elevation = 30.dp, shape = RoundedCornerShape(30.dp)) {


        Toast.makeText(context, Indexname, Toast.LENGTH_SHORT).show()
    }

}
