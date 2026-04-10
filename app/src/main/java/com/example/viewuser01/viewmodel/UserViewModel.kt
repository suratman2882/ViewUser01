package com.example.viewuser01.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viewuser01.model.User

class UserViewModel : ViewModel() {

    // Simulasi data database
    private val users = listOf(
        User(1, "Naruto", "Ninja dari Konaha"),
        User(2, "Sasuke", "Pencari Keadilan"),
        User(3, "Sakura", "Medis Ninja Hebat")
    )

    // Fungsi untuk mendapatkan daftar user
    fun getUsers(): List<User> = users

    // Fungsi untuk mencari satu user berdasarkan ID
    fun getUserById(id: Int): User? {
        return users.find { it.id == id }
    }
}