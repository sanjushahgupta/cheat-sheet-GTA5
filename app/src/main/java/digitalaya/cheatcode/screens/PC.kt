package digitalaya.cheatcode.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import digitalaya.cheatcode.R

@Composable
fun PC(navController: NavController) {
    val PCList = listOf(
        stringResource(R.string.InvincibilityPc),
        stringResource(R.string.TURTLEPc),
        stringResource(R.string.SuperJumpPc),
        stringResource(R.string.FLOATERPc),
        stringResource(R.string.FUGITIVEPc),
        stringResource(R.string.LAWYERUPPc),
        stringResource(R.string.CATCHMEPc),
        stringResource(R.string.GOTGILLSPc),
        stringResource(R.string.POWERUPPc),
        stringResource(R.string.SKYFALLPc),
        stringResource(R.string.HOTHANDSPc),
        stringResource(R.string.FlamingBullets),
        stringResource(R.string.HIGHEXPc),
        stringResource(R.string.INCENDIARYPc),
        stringResource(R.string.DEADEYEPc),
        stringResource(R.string.LIQUORPc),
        stringResource(R.string.TOOLUPPc),
        stringResource(R.string.SKYDIVEPc),
        stringResource(R.string.BUZZOFFPc),
        stringResource(R.string.COMETPc),
        stringResource(R.string.OFFROADPc),
        stringResource(R.string.TRASHEDPc),
        stringResource(R.string.VINEWOODPc),
        stringResource(R.string.BARNSTORMPc),
        stringResource(R.string.HOLEIN1Pc),
        stringResource(R.string.RAPIDGTPc),
        stringResource(R.string.FLYSPRAYPc),
        stringResource(R.string.ROCKETPc),
        stringResource(R.string.BANDITPc),
        stringResource(R.string.MAKEITRAINPc),
        stringResource(R.string.SNOWDAYPc),
        stringResource(R.string.SLOWMOPc)
    )
    val PCListDetails = listOf(
        stringResource(R.string.InvincibilityPcDetails),
        stringResource(R.string.TURTLEPcDetails),
        stringResource(R.string.SuperJumpPcDetails),
        stringResource(R.string.FLOATERPcDetails),
        stringResource(R.string.FUGITIVEPcDetails),
        stringResource(R.string.LAWYERUPPcDetails),
        stringResource(R.string.CATCHMEPcDetails),
        stringResource(R.string.GOTGILLSPcDetails),
        stringResource(R.string.POWERUPPcDetails),
        stringResource(R.string.SKYFALLPcDetails),
        stringResource(R.string.HOTHANDSPcDetails),
        stringResource(R.string.FlamingBulletsDetails),
        stringResource(R.string.HIGHEXPcDetails),
        stringResource(R.string.INCENDIARYPcDetails),
        stringResource(R.string.DEADEYEPcDetails),
        stringResource(R.string.LIQUORPcDetails),
        stringResource(R.string.TOOLUPPcDetails),
        stringResource(R.string.SKYDIVEPcDetails),
        stringResource(R.string.BUZZOFFPcDetails),
        stringResource(R.string.COMETPcDetails),
        stringResource(R.string.OFFROADPcDetails),
        stringResource(R.string.TRASHEDPcDetails),
        stringResource(R.string.VINEWOODPcDetails),
        stringResource(R.string.BARNSTORMPcDetails),
        stringResource(R.string.HOLEIN1PcDetails),
        stringResource(R.string.RAPIDGTPcDetails),
        stringResource(R.string.FLYSPRAYPcDetails),
        stringResource(R.string.ROCKETPcDetails),
        stringResource(R.string.BANDITPcDetails),
        stringResource(R.string.MAKEITRAINPcDetails),
        stringResource(R.string.SNOWDAYPcDetails),
        stringResource(R.string.SLOWMOPcDetails)
    )
    digitalaya.cheatcode.screens.Scaffold(
        navController = navController,
        title = "PC",
    list = PCList,
        listDetails = PCListDetails,
    )


}
