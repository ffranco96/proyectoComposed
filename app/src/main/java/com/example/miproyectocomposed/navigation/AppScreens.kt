package com.example.miproyectocomposed.navigation

sealed class AppScreens(val route: String) {
    object HomeStartScreen: AppScreens("home_start_screen")
    object AddRegisterAmountScreen: AppScreens("add_register_amount_screen")
}