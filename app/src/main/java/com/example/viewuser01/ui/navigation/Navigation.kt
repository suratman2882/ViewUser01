package com.example.viewuser01.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.compose.runtime.collectAsState
import com.example.viewuser01.ui.screens.UserDetailScreen
import com.example.viewuser01.ui.screens.UserListScreen
import com.example.viewuser01.viewmodel.UserViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: UserViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = "user_list"
    ) {

        // 🔹 Screen: List User
        composable("user_list") {

            val uiState = viewModel.uiState.collectAsState().value

            UserListScreen(
                uiState = uiState,
                onUserClicked = { userId ->
                    navController.navigate("user_detail/$userId")
                },
                onRetryClick = {
                    viewModel.fetchUsers()
                }
            )
        }

        // 🔹 Screen: Detail User
        composable(
            route = "user_detail/{userId}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val userId = backStackEntry.arguments?.getInt("userId")
            val user = userId?.let { viewModel.getUserById(it) }

            if (user != null) {
                UserDetailScreen(user = user)
            }
        }
    }
}
