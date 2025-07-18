package io.ngss.yemeksepetimerch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ngss.yemeksepetimerch.components.AgreementsSection
import io.ngss.yemeksepetimerch.components.CheckoutTopBar
import io.ngss.yemeksepetimerch.components.OrderSummarySection
import io.ngss.yemeksepetimerch.components.PaymentMethodSection
import io.ngss.yemeksepetimerch.components.TipSection
import io.ngss.yemeksepetimerch.ui.theme.lightGrayBackground

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen()
}