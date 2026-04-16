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

    init {
        fetchUsers()
    }

    // 🔥 harus public supaya bisa dipanggil dari UI
    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val users = ApiClient.api.getUsers() // ✔ FIX typo
                _uiState.value = UserUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error("Gagal mengambil data: ${e.message}")
            }
        }
    }

    // 🔥 ambil user berdasarkan ID
    fun getUserById(id: Int): User? {
        val currentState = _uiState.value
        return if (currentState is UserUiState.Success) {
            currentState.users.find { it.id == id }
        } else {
            null
        }
    }
}