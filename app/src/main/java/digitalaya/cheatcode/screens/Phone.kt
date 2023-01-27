package digitalaya.cheatcode.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

import digitalaya.cheatcode.R


@Composable
fun Phone(navController: NavController) {
    val PhoneList = listOf(
        stringResource(R.string.InvincibilityPhone),
        stringResource(R.string.MaxHealthandArmorPhone),
        stringResource(R.string.SuperJumpPhone),
        stringResource(R.string.MoonGravityPhone),
        stringResource(R.string.RaiseWantedLevelPhone),
        stringResource(R.string.LowerWantedLevelPhone),
        stringResource(R.string.FastRunPhone),
        stringResource(R.string.FastSwimPhone),
        stringResource(R.string.RechargeAbilityPhone),
        stringResource(R.string.SkyfallPhone),
        stringResource(R.string.ExplosiveMeleeAttacksPhone),
        stringResource(R.string.BangBangPhone),
        stringResource(R.string.FlamingBulletsPhone),
        stringResource(R.string.SlowMotionAimPhone),
        stringResource(R.string.DrunkModePhone),
        stringResource(R.string.GiveWeaponsandAmmoPhone),
        stringResource(R.string.GiveParachutePhone),
        stringResource(R.string.SpawnBuzzardPhone),
        stringResource(R.string.SpawnCometPhone),
        stringResource(R.string.SpawnSanchezPhone),
        stringResource(R.string.SpawnTrashmasterPhone),
        stringResource(R.string.SpawnLimoPhone),
        stringResource(R.string.SpawnStuntPlanePhone),
        stringResource(R.string.SpawnCaddyPhone),
        stringResource(R.string.SpawnRapidGTPhone),
        stringResource(R.string.SpawnDusterPhone),
        stringResource(R.string.SpawnPCJPhone),
        stringResource(R.string.SpawnBMXPhone),
        stringResource(R.string.ChangeWeatherPhone),
        stringResource(R.string.SlideyCarsPhone),
        stringResource(R.string.SlowMotionPhone),

        )
    val PhoneListDetails = listOf(
        stringResource(R.string.InvincibilityPhoneDetails),
        stringResource(R.string.MaxHealthandArmorPhoneDetails),
        stringResource(R.string.SuperJumpPhoneDetails),
        stringResource(R.string.MoonGravityPhoneDetails),
        stringResource(R.string.RaiseWantedLevelPhoneDetails),
        stringResource(R.string.LowerWantedLevelPhoneDetails),
        stringResource(R.string.FastRunPhoneDetails),
        stringResource(R.string.FastSwimPhoneDetails),
        stringResource(R.string.RechargeAbilityPhoneDetails),
        stringResource(R.string.SkyfallPhoneDetails),
        stringResource(R.string.ExplosiveMeleeAttacksPhoneDetails),
        stringResource(R.string.BangBangPhoneDetails),
        stringResource(R.string.FlamingBulletsPhoneDetails),
        stringResource(R.string.SlowMotionAimPhoneDetails),
        stringResource(R.string.DrunkModePhoneDetails),
        stringResource(R.string.GiveWeaponsandAmmoPhoneDetails),
        stringResource(R.string.GiveParachutePhoneDetails),
        stringResource(R.string.SpawnBuzzardPhoneDetails),
        stringResource(R.string.SpawnCometfPhoneDetails),
        stringResource(R.string.SpawnSanchezPhoneDetails),
        stringResource(R.string.SpawnTrashmasterfPhoneDetails),
        stringResource(R.string.SpawnLimoPhoneDetails),
        stringResource(R.string.SpawnStuntPlanePhoneDetails),
        stringResource(R.string.SpawnCaddyPhoneDetails),
        stringResource(R.string.SpawnRapidGTPhoneDetails),
        stringResource(R.string.SpawnDusterPhoneDetails),
        stringResource(R.string.SpawnPCJPhoneDetails),
        stringResource(R.string.SpawnBMXPhoneDetails),
        stringResource(R.string.ChangeWeatherPhoneDetails),
        stringResource(R.string.SlideyCarsPhoneDetails),
        stringResource(R.string.SlowMotionPhoneDetails)
    )

    val title = "Phone"
    Scaffold(navController, title, PhoneList, PhoneListDetails)


}
