package io.ngss.yemeksepetimerch.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily
import io.ngss.yemeksepetimerch.ui.theme.lightGrayBackground
import io.ngss.yemeksepetimerch.ui.theme.textGreen

@Composable
fun OrderSummarySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Order summary",
            fontFamily = interFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        OrderItem("1x Yudum Egemden Yumuşak Lezzet Sız...", "199,90 TL")
        OrderItem("1x Milagro 2'li Limon", "37,90 TL")
        OrderItem("1x Komili Islak Havlu 3x 60 adet", "129,90 TL")

        HorizontalDivider(thickness = 1.dp, color = lightGrayBackground)


        PriceDetailRow("Subtotal", "367,70 TL")
        PriceDetailRow("Standard Delivery", "Free", valueColor = textGreen)
        PriceDetailRow("Plastic bag fee (1x)", "0,50 TL")
        PriceDetailRow(
            "İlk Market siparişine 200 TL indirim",
            "- 200,00 TL",
            valueColor = textGreen
        )
    }
}

@Preview
@Composable
private fun OrderSummarySectionPreview() {
    OrderSummarySection()
}
