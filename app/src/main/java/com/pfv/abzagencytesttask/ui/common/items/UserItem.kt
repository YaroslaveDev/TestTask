package com.pfv.abzagencytesttask.ui.common.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pfv.abzagencytesttask.data.dvo.UserDvo
import com.pfv.abzagencytesttask.data.dvo.UsersDvo
import com.pfv.abzagencytesttask.ui.common.other.ImageFromNetwork
import com.pfv.abzagencytesttask.ui.theme.Black_87
import com.pfv.abzagencytesttask.ui.theme.Grey

@Composable
fun UserItem(
    modifier: Modifier,
    user: UserDvo
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            ImageFromNetwork(
                modifier = Modifier
                    .size(50.dp),
                imgSource = user.photo
            )

            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = user.name,
                    color = Black_87,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = user.email,
                    color = Black_87,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = user.phone,
                    color = Black_87,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 66.dp),
            thickness = 1.dp,
            color = Grey
        )
    }
}