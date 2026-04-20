package com.example.viewuser01.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewuser01.model.User
import com.example.viewuser01.network.ApiClient
import com.example.viewuser01.ui.state.UserUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.collections.find

class UserViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val uiState: StateFlow<UserUiState> = _uiState

    // 🔥 TAMBAHAN: selected user
    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val users = ApiClient.api.getUsers()
                _uiState.value = UserUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error("Gagal mengambil data: ${e.message}")
            }
        }
    }

    // 🔥 FIX: pilih user, bukan ambil langsung di detail
    fun selectUser(id: Int) {
        val currentState = _uiState.value
        if (currentState is UserUiState.Success) {
            _selectedUser.value = currentState.users.find { it.id == id }
        }
    }
}