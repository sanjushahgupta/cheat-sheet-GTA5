package digitalaya.cheatcode.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import digitalaya.cheatcode.R

@Composable
fun PlayStation(navController: NavController) {
    val PlayStationList = listOf(
        stringResource(R.string.InvincibilityPf),
        stringResource(R.string.MaxHealthandArmorPf),
        stringResource(R.string.SuperJumpPf),
        stringResource(R.string.MoonGravityPf),
        stringResource(R.string.RaiseWantedLevelPf),
        stringResource(R.string.LowerWantedLevelPf),
        stringResource(R.string.FastRunPf),
        stringResource(R.string.FastSwimPf),
        stringResource(R.string.RechargeAbilityPf),
        stringResource(R.string.SkyfallPf),
        stringResource(R.string.ExplosiveMeleeAttacksPf),
        stringResource(R.string.BangBangPf),
        stringResource(R.string.FlamingBulletsPf),
        stringResource(R.string.SlowMotionAimPf),
        stringResource(R.string.DrunkModePf),
        stringResource(R.string.GiveWeaponsandAmmoPf),
        stringResource(R.string.GiveParachutePf),
        stringResource(R.string.SpawnBuzzardPf),
        stringResource(R.string.SpawnCaddyPf),
        stringResource(R.string.SpawnSanchezPf),
        stringResource(R.string.SpawnTrashmasterPf),
        stringResource(R.string.SpawnLimoPf),
        stringResource(R.string.SpawnStuntPlanePf),
        stringResource(R.string.SpawnCaddyPf),
        stringResource(R.string.SpawnRapidGTPf),
        stringResource(R.string.SpawnDusterPf),
        stringResource(R.string.SpawnPCJPf),
        stringResource(R.string.SpawnBMXPf),
        stringResource(R.string.ChangeWeatherPf),
        stringResource(R.string.SlideyCarsPf),
        stringResource(R.string.SlowMotionPf),

    )
    val PlayStationListDetails = listOf(
        stringResource(R.string.InvincibilityPfDetails),
        stringResource(R.string.MaxHealthandArmorPfDetails),
        stringResource(R.string.SuperJumpPfDetails),
        stringResource(R.string.MoonGravityPfDetails),
        stringResource(R.string.RaiseWantedLevelPfDetails),
        stringResource(R.string.LowerWantedLevelPfDetails),
        stringResource(R.string.FastRunPfDetails),
        stringResource(R.string.FastSwimPfDetails),
        stringResource(R.string.RechargeAbilityPfDetails),
        stringResource(R.string.SkyfallPfDetails),
        stringResource(R.string.ExplosiveMeleeAttacksPfDetails),
        stringResource(R.string.BangBangPfDetails),
        stringResource(R.string.FlamingBulletsPfPfDetails),
        stringResource(R.string.SlowMotionAimPfDetails),
        stringResource(R.string.DrunkModePfDetails),
        stringResource(R.string.GiveWeaponsandAmmoPfDetails),
        stringResource(R.string.GiveParachutePfDetails),
        stringResource(R.string.SpawnBuzzardPfDetails),
        stringResource(R.string.SpawnCaddyPfDetails),
        stringResource(R.string.SpawnSanchezPfDetails),
        stringResource(R.string.SpawnTrashmasterfPfDetails),
        stringResource(R.string.SpawnLimoPfDetails),
        stringResource(R.string.SpawnStuntPlanePfDetails),
        stringResource(R.string.SpawnCaddyPfDetails),
        stringResource(R.string.SpawnRapidGTPfDetails),
        stringResource(R.string.SpawnDusterPfDetails),
        stringResource(R.string.SpawnPCJPfDetails),
        stringResource(R.string.SpawnBMXPfDetails),
        stringResource(R.string.ChangeWeatherPfDetails),
        stringResource(R.string.SlideyCarsPfDetails),
        stringResource(R.string.SlowMotionPfDetails))

    val title = "PlayStation"
    Scaffold(navController,title,PlayStationList, PlayStationListDetails, "0")




}
