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
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.TransferWithinAStation
import androidx.compose.material.icons.rounded.Wallet
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
import com.ahmedapps.bankningappui.ui.theme.BlueStart
import com.ahmedapps.bankningappui.ui.theme.GreenStart
import com.ahmedapps.bankningappui.ui.theme.OrangeStart
import com.ahmedapps.bankningappui.ui.theme.PurpleStart

val SubmitList = listOf(
    Finance(
        icon = Icons.Rounded.Send,
        name = "Kirim",
        background = Color.Green
    ),

    Finance(
        icon = Icons.Rounded.Wallet,
        name = "Batal",
        background = Color.Red
    ),
)

@Preview
@Composable
fun SubmitSection(onFinanceItemClick: (Int) -> Unit = {}) {
    Column {
        Text(
            text = "Features",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(SubmitList.size) { index ->
                SubmitItem(index = index, onClick = { onFinanceItemClick(index) })
            }
        }
    }
}

@Composable
fun SubmitItem(
    index: Int,
    onClick: () -> Unit // Tambahkan parameter onClick
) {
    val finance = SubmitList[index]
    var lastPaddingEnd = 0.dp
    if (index == SubmitList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { onClick() } // Panggil onClick ketika card diklik
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
