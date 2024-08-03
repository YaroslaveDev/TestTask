package com.pfv.abzagencytesttask.ui.screens.users

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.data.dvo.UserDvo
import com.pfv.abzagencytesttask.data.dvo.UsersDvo
import com.pfv.abzagencytesttask.ui.common.items.UserItem
import com.pfv.abzagencytesttask.ui.screens.users.screen_state.UsersScreenState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UsersScreenContent(
    screenState: UsersScreenState,
    users: List<UserDvo>
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface
    ) {

        when (screenState) {
            UsersScreenState.EmptyState -> {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_users_placeholder),
                        contentDescription = "img"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = stringResource(id = R.string.empty_users_list),
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            UsersScreenState.SetupState -> {

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
            UsersScreenState.SuccessState -> {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .statusBarsPadding(),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(bottom = 30.dp)
                ){

                    items(users){

                        UserItem(
                            modifier = Modifier
                                .fillMaxWidth(),
                            user = it
                        )
                    }
                }
            }
        }
    }
}