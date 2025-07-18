package io.ngss.yemeksepetimerch.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ngss.yemeksepetimerch.ui.theme.brandPink
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily

@Composable
fun TipButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (isSelected) brandPink.copy(alpha = 0.1f) else Color.Transparent,
            contentColor = if (isSelected) brandPink else Color.Black
        ),
        border = BorderStroke(
            1.dp,
            if (isSelected) brandPink else Color.LightGray
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text, fontFamily = interFontFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
private fun TipButtonEnabledPreview() {
    TipButton(
        text = "Tip now",
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
private fun TipButtonDisablePreview() {
    TipButton(
        text = "Tip now",
        isSelected = false,
        onClick = {}
    )
}