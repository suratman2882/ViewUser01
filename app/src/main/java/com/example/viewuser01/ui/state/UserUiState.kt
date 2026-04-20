package com.example.viewuser01.ui.state

import com.example.viewuser01.model.User

sealed class UserUiState {
    object Loading : UserUiState()
    data class Success(val users: List<User>) : UserUiState()
    data class Error(val message: String) : UserUiState()
    object Empty : UserUiState()
}