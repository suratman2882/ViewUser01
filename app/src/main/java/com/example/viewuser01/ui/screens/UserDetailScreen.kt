package com.example.viewuser01.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewuser01.model.User

class UserDetailScreen {
}
@Composable
fun UserDetailScreen(user: User){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = user.name, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = user.description, fontSize = 18.sp)
    }
}