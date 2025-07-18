package io.ngss.yemeksepetimerch.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.components.buttons.TipButton
import io.ngss.yemeksepetimerch.ui.theme.brandPink
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily

val tips = listOf("Tip now", "15,00 TL", "20,00 TL", "25,00 TL", "30,00 TL")

@Composable
fun TipSection() {
    var selectedTip by remember { mutableStateOf<String?>(null) }
    var saveTipChecked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(tips) { tip ->
                    TipButton(
                        text = tip,
                        isSelected = tip == selectedTip,
                        onClick = { selectedTip = tip }
                    )
                }
            }

            Text(
                text = "Most common",
                fontWeight = FontWeight.SemiBold,
                fontFamily = interFontFamily,
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Checkbox(
                    checked = saveTipChecked,
                    onCheckedChange = { saveTipChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = brandPink,
                        uncheckedColor = Color.Gray
                    )
                )
                Text(
                    text = "Save it for next order",
                    fontFamily = interFontFamily,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TipSectionPreview() {
    Box(
        modifier = Modifier.padding(16.dp),
    ) {
        TipSection()
    }
}