package com.ahmedapps.bankningappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.HeartBroken
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.MonitorHeart
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedapps.bankningappui.data.Finance

val financebottomList = listOf(
    Finance(
        icon = Icons.Rounded.HeartBroken,
        name = "Donasi",
        background = Color.Blue
    ),

    Finance(
        icon = Icons.Rounded.Notes,
        name = "Catatan",
        background = Color.Magenta
    ),

    Finance(
        icon = Icons.Rounded.MonitorHeart,
        name = "Asuransi",
        background = Color.Red
    ),

    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = Color.Red
    ),
)

@Preview
@Composable
fun FinancebottomSection() {
    Column {
        Text(
            text = "",
            fontSize = 10.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(1.dp)
        )

        LazyRow {
            items(financebottomList.size) {
                FinancebottomItem(it)
            }
        }
    }
}

@Composable
fun FinancebottomItem(
    index: Int
) {
    val finance = financebottomList[index]
    var lastPaddingEnd = 0.dp
    if (index == financebottomList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }

            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

        }
    }
}













