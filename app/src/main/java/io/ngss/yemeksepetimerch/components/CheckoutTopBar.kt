package io.ngss.yemeksepetimerch.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily
import io.ngss.yemeksepetimerch.ui.theme.lightText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutTopBar() {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = "Checkout",
                    fontWeight = FontWeight.Bold,
                    fontFamily = interFontFamily,
                    fontSize = 20.sp
                )
                Text(
                    text = "Yemeksepeti Market, Göztepe (Istanbul)",
                    fontSize = 14.sp,
                    fontFamily = interFontFamily,
                    color = lightText
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Preview
@Composable
private fun CheckoutTopBarPreview() {
    CheckoutTopBar()
}