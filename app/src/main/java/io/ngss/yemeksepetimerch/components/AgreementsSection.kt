package io.ngss.yemeksepetimerch.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.ui.theme.brandPink
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily
import io.ngss.yemeksepetimerch.ui.theme.lightText

@Composable
fun AgreementsSection() {
    var isChecked by remember { mutableStateOf(true) }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = brandPink,
                    uncheckedColor = lightText
                )
            )
            Text(
                text = buildAnnotatedString {
                    append("I have read and accept the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Distance Sales Agreement")
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Preliminary Information")
                    }
                },
                fontSize = 14.sp,
                fontFamily = interFontFamily,
                color = lightText
            )
        }
        Text(
            text = buildAnnotatedString {
                append("By completing this order, I agree to all ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("terms & conditions.")
                }
            },
            fontSize = 14.sp,
            fontFamily = interFontFamily,
            color = lightText
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AgreementsSectionPreview() {
    AgreementsSection()
}