package io.mmaltsev.vkeducation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.mmaltsev.vkeducation.presentation.appdetails.AppDetailsScreen
import io.mmaltsev.vkeducation.presentation.applist.AppsScreen

object Routes {
    const val APP_LIST = "app_list"
    const val APP_DETAILS = "app_details"
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.APP_LIST,
    ) {
        composable(Routes.APP_LIST) {
            AppsScreen(
                onAppClick = { navController.navigate(Routes.APP_DETAILS) },
            )
        }
        composable(Routes.APP_DETAILS) {
            AppDetailsScreen(
                onBack = { navController.popBackStack() },
                onShowcaseAppClick = {
                    navController.popBackStack(Routes.APP_LIST, inclusive = false)
                },
            )
        }
    }
}
