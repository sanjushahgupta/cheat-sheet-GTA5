package digitalaya.cheatcode.screens

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import digitalaya.cheatcode.PopupWindowDialog
import digitalaya.cheatcode.R


@Composable
fun Xbox(navController: NavController) {
    val modifier = Modifier
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

    val xboxList = listOf(
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
    val xboxListDetails = listOf(
        stringResource(R.string.InvincibilityDetails),
        stringResource(R.string.MaxHealthandArmorDetails),
        stringResource(R.string.SuperJumpDetails),
        stringResource(R.string.MoonGravityDetails),
        stringResource(R.string.RaiseWantedLevelDetails),
        stringResource(R.string.LowerWantedLevelDetails),
        stringResource(R.string.FastRunDetails),
        stringResource(R.string.FastSwimDetails),
        stringResource(R.string.RechargeAbilityDetails),
        stringResource(R.string.SkyfallDetails),
        stringResource(R.string.ExplosiveBulletsDetails),
        stringResource(R.string.FlamingBulletsDetails),
        stringResource(R.string.SlowMotionAimDetails),
        stringResource(R.string.DrunkModeDetails),
        stringResource(R.string.WeaponsDetails),
        stringResource(R.string.GiveParachuteDetails),
        stringResource(R.string.SpawnBuzzardDetails),
        stringResource(R.string.SpawnCometDetails),
        stringResource(R.string.SpawnSanchezDetails),
        stringResource(R.string.SpawnTrashmasterDetails),
        stringResource(R.string.SpawnLimoDetails),
        stringResource(R.string.SpawnStuntPlaneDetails),
        stringResource(R.string.SpawnCaddyDetails),
        stringResource(R.string.SpawnRapidGTDetails),
        stringResource(R.string.SpawnDusterDetails),
        stringResource(R.string.SpawnPCJDetails),
        stringResource(R.string.SpawnBMXDetails),
        stringResource(R.string.ChangeWeatherDetails),
        stringResource(R.string.SlideyCarsDetails),
        stringResource(R.string.SlowMotionDetails)
    )
    var Index = 0
    val detailsStatus = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(xboxList) { item ->
                Divider()
                // detailsStatus.value = false
                Column(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .clickable {
                        Index = xboxList.indexOf(item)

                        detailsStatus.value = !detailsStatus.value
                    }) {

                    Text(text = item, modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            Index = xboxList.indexOf(item)

                            detailsStatus.value = !detailsStatus.value
                        })

                    if (detailsStatus.value) {
                        PopUpdetails(xboxListDetails, Index)
                    }

                }
                Divider()

            }


        }


    }
}

@Composable
fun PopUpdetails(xboxListDetails: List<String>, Index: Int) {

    val valueOfXboxIndex = xboxListDetails[Index]
    val cardStatus = remember {
        mutableStateOf(true)
    }

    if (cardStatus.value) {
        Card(elevation = 30.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable { cardStatus.value = false }
                .padding(top = 10.dp, bottom = 10.dp),
            backgroundColor = Color.LightGray

        ) {
            Text(
                text = valueOfXboxIndex, modifier = Modifier.padding(15.dp), fontWeight = FontWeight.Bold
            )

        }

    }

}
