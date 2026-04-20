package com.example.viewuser01.ui.navigation

import androidx.compose.material3.Text
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

        // 🔹 LIST SCREEN
        composable("user_list") {
            val uiState = viewModel.uiState.collectAsState().value

            UserListScreen(
                uiState = uiState,
                onUserClicked = { userId ->
                    viewModel.selectUser(userId) // 🔥 penting
                    navController.navigate("user_detail")
                },
                onRetryClick = {
                    viewModel.fetchUsers()
                }
            )
        }

        // 🔹 DETAIL SCREEN
        composable("user_detail") {
            val user = viewModel.selectedUser.collectAsState().value

            if (user != null) {
                UserDetailScreen(
                    user = user,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            } else {
                Text("Data user tidak ditemukan")
            }
        }
    }
}