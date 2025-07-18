package io.ngss.yemeksepetimerch.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily
import io.ngss.yemeksepetimerch.ui.theme.lightText

@Composable
fun OrderItem(name: String, price: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = name,
            fontSize = 13.sp,
            fontFamily = interFontFamily,
            modifier = Modifier.weight(1f),
            color = lightText
        )
        Text(
            text = price,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderItemPreview() {
    OrderItem(
        name = "1x Yudum Egemden Yumuşak Lezzet Sız...",
        price = "199,90 TL"
    )
}