package io.ngss.yemeksepetimerch

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ngss.yemeksepetimerch.ui.theme.brandPink
import io.ngss.yemeksepetimerch.ui.theme.interFontFamily
import io.ngss.yemeksepetimerch.ui.theme.lightGrayBackground
import io.ngss.yemeksepetimerch.ui.theme.lightText
import io.ngss.yemeksepetimerch.ui.theme.textGreen

@Composable
fun CheckoutScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { CheckoutTopBar() },
        bottomBar = { CheckoutBottomBar() },
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(lightGrayBackground)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { TipSection() }
            item { PaymentMethodSection() }
            item { OrderSummarySection() }
            item { AgreementsSection() }
            item { Spacer(modifier = Modifier.height(8.dp)) }
        }
    }
}

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
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
    ) {
        Text(
            text = text, fontFamily = interFontFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun PaymentMethodSection() {
    var isChecked by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Payment method",
                fontFamily = interFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = { }) {
                Text(
                    text = "Change",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CreditCard,
                    contentDescription = "Mastercard",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Mastercard",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "•••• 5868",
                        fontFamily = interFontFamily,
                        color = lightText,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "168,20 TL",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = interFontFamily,
                )
            }
        }
    }
}

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
        Text(text = "Order summary", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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

@Composable
fun OrderItem(name: String, price: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = name, modifier = Modifier.weight(1f), color = lightText)
        Text(text = price, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun PriceDetailRow(label: String, value: String, valueColor: Color = Color.Black) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = label, modifier = Modifier.weight(1f), color = lightText)
        Text(text = value, fontWeight = FontWeight.SemiBold, color = valueColor)
    }
}

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
            color = lightText
        )
    }
}

@Composable
fun CheckoutBottomBar() {
    Surface(
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Total (incl. fees and tax)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "See summary",
                        color = lightText,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "168,20 TL",
                        color = textGreen,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "448,19 TL",
                        color = lightText,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = brandPink)
            ) {
                Text(text = "Place Order", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen()
}