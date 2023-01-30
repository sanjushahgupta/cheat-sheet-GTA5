package digitalaya.grandcodes.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import digitalaya.cheatcode.R
import digitalaya.grandcodes.UserPreference
import kotlinx.coroutines.launch

@SuppressLint(
    "UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition",
    "SuspiciousIndentation"
)

@Composable
fun Xbox(navController: NavController) {
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
        stringResource(R.string.ExplosiveMeleeAttacks),
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
        stringResource(R.string.ExplosiveMeleeAttacksDetails),
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
    val title = "Xbox"
    Scaffold(navController, title, xboxList, xboxListDetails)
}

@Composable
fun Scaffold(
    navController: NavController,
    title: String,
    list: List<String>,
    listDetails: List<String>,
) {

    val modifier = Modifier
    val popUpState = remember { mutableStateOf(false) }

    Scaffold(topBar = {
        Divider(color = Color.Black)
        TopAppBar(
            modifier.fillMaxWidth(),
            backgroundColor = colorResource(id = R.color.light_green)
        ) {

            Text(
                text = "Grand Auto Codes - $title",
                modifier.padding(start = 10.dp, bottom = 10.dp, top = 5.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                color = Color.White
            )


            Spacer(modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                contentDescription = "",
                modifier
                    .clickable(MutableInteractionSource(),
                        indication = null,
                        onClick = { popUpState.value = true })
                    .padding(end = 15.dp),
                tint = Color.White
            )

        }
    }) {
        Box(
            modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White)
                .clickable(MutableInteractionSource(),
                    indication = null,
                    onClick = { }
                )
                .fillMaxSize()
        ) {

            GrantCode(list, listDetails)
            if (popUpState.value) {
                SettingDialogBox(navController, popUpState,title)
            }
        }
    }
}

@Composable
fun GrantCode(listOfCodes: List<String>, listOfCodesDetails: List<String>) {

    var Indexx = remember { mutableStateOf(55) }
    val detailsStatus = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 15.dp)


    ) {
        if (detailsStatus.value) {

            DetailsDialogBox(listOfCodesDetails, listOfCodes, Indexx.value, detailsStatus)

        }
        LazyColumn {


            items(listOfCodes) { item ->


                Divider()


                Column(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .clickable {
                        detailsStatus.value = true
                        Indexx.value = listOfCodes.indexOf(item)
                    }) {

                    Text(text = item, modifier = Modifier
                        .padding(5.dp)
                        .clickable {
                            detailsStatus.value = true
                            Indexx.value = listOfCodes.indexOf(item)
                        },
                        fontSize = 17.sp

                    )

                }

                Divider()

            }


        }

    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsDialogBox(
    listOfCodesDetails: List<String>,
    listOfCodes: List<String>,
    Index: Int,
    popUpShow: MutableState<Boolean>
) {

    var valueOfIndex = listOfCodesDetails[Index]
    var valueOfListIndex = listOfCodes[Index]
    var popupShow = remember {
        mutableStateOf(popUpShow)
    }
    if (popupShow.value.value) {
        Dialog(
            onDismissRequest = {
                popupShow.value.value = false
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        colorResource(id = R.color.white),
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    valueOfListIndex,
                    modifier = Modifier.padding( top = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
                    Text(
                        text = valueOfIndex,
                        modifier = Modifier.padding(start = 10.dp, top = 15.dp, end = 10.dp, bottom = 15.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 17.sp
                    )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.End
                ) {

                    Text(
                        "Close",
                        color = colorResource(id = R.color.teal_200),
                        fontWeight = SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(top = 15.dp, bottom = 10.dp, end = 10.dp)
                            .clickable { popupShow.value.value = false })


                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SettingDialogBox(
    navController: NavController,
    popUpShow: MutableState<Boolean>,
    selectIndexName: String
) {
    var popupShow = remember {
        mutableStateOf(popUpShow)
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val dataStore = UserPreference(context)

    if (popupShow.value.value) {
        Dialog(
            onDismissRequest = {
                popupShow.value.value = false
            }
        ) {
            Card(
                elevation = 20.dp,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                 //   .padding(10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                val gamesOption = listOf("PlayStation", "Xbox", "PC", "Phone")

                val (selectedOptions, onOptionsSelected) = remember { mutableStateOf(selectIndexName) }

                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .background(colorResource(id = R.color.teal_200)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                 
                    Text(
                        "Platform",
                        color = Color.White,
                        fontWeight = SemiBold,
                        fontSize = 19.sp,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                    )
                 
                    gamesOption.forEach { text ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(selected = (text == selectedOptions),
                                    onClick = {
                                        onOptionsSelected(text)
                                        scope.launch {
                                            dataStore.savePlatformIndexStatus(text)
                                            navController.navigate(text)
                                        }

                                    })

                        ) {

                            RadioButton(

                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.White
                                ),
                                selected = (text == selectedOptions), onClick = {
                                    onOptionsSelected(text)
                                    scope.launch {
                                        dataStore.savePlatformIndexStatus(text)
                                        navController.navigate(text)
                                    }


                                }
                            )
                            Text(
                                text = text,
                               modifier = Modifier.padding(top =10.dp),
                                color = Color.White,
                                fontSize = 17.sp
                            )

                        }


                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.End
                    ) {

                        Text(
                            "Close",
                            color = Color.White,
                            fontWeight = SemiBold,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(top = 15.dp, bottom = 15.dp, end = 15.dp)
                                .clickable { popupShow.value.value = false })
                    }

                }
            }
        }
    }
}
