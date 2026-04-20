package com.example.viewuser01.ui.screens

import androidx.compose.foundation.clickable
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

@Composable
fun UserDetailScreen(
    user: User,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "← Kembali",
            modifier = Modifier
                .clickable { onBack() }
                .padding(bottom = 16.dp)
        )

        Text(text = user.name, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = user.email, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(6.dp))

        Text(text = user.phone, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(6.dp))

        Text(text = user.website, fontSize = 16.sp)
    }
}