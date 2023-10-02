package com.example.qrcode

import androidx.camera.core.ExperimentalGetImage
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.qrcode.scan.ScanScreen
import com.example.qrcode.scan_result.ScanResultScreen

const val qrCodeScanRoute = "qrCodeScan"
const val qrCodeResultRoute = "qrCodeResultRoute"
const val ARG_QRCODE_VALUE = "argQrcodeValue"

@Composable
@ExperimentalGetImage
fun QrCodeNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = qrCodeScanRoute
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = qrCodeScanRoute) {
            ScanScreen(onScan = {
                    navController.navigate("$qrCodeResultRoute/${it.displayValue}")
            }
            )
        }
        composable(route = "$qrCodeResultRoute/{$ARG_QRCODE_VALUE}", arguments = listOf(
            navArgument(ARG_QRCODE_VALUE) {
                type = NavType.StringType
            })) {
            ScanResultScreen(it.arguments?.getString(ARG_QRCODE_VALUE))
        }
    }
}