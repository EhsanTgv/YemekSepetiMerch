package io.ngss.yemeksepetimerch.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily
import io.ngss.yemeksepetimerch.ui.theme.lightText

@Composable
fun PriceDetailRow(label: String, value: String, valueColor: Color = Color.Black) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontFamily = interFontFamily,
            modifier = Modifier.weight(1f),
            color = lightText
        )
        Text(
            text = value,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            color = valueColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceDetailRowPreview() {
    PriceDetailRow(
        label = "Subtotal",
        value = "367,70 TL",
        valueColor = Color.Black
    )
}
