package com.pfv.abzagencytesttask.ui.screens.users

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.ui.common.items.UserItem
import com.pfv.abzagencytesttask.ui.common.other.InfoScreen
import com.pfv.abzagencytesttask.ui.navigation.routes.BaseAppRoutes
import com.pfv.abzagencytesttask.ui.screens.users.nav_state.UsersScreenNavState
import com.pfv.abzagencytesttask.ui.screens.users.screen_state.UsersScreenState
import com.pfv.abzagencytesttask.ui.screens.users.ui_state.UsersScreenUiState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UsersScreen(
    navController: NavController,
    viewModel: UsersScreenViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }

    when(viewModel.uiState){
        is UsersScreenUiState.Error -> {
            InfoScreen(
                actionText = stringResource(id = R.string.try_again),
                text = stringResource(id = R.string.no_internet_connection),
                img = R.drawable.img_no_internet_connection,
                onAction = {},
                onCloseInfoScreen = {}
            )
        }
        UsersScreenUiState.InitState -> {
            UsersScreenContent(
                screenState = viewModel.screenState,
                users = viewModel.users
            )
        }
        UsersScreenUiState.NoInternetConnection -> {
            InfoScreen(
                actionText = stringResource(id = R.string.try_again),
                text = stringResource(id = R.string.no_internet_connection),
                img = R.drawable.img_no_internet_connection,
                onAction = {},
                onCloseInfoScreen = {}
            )
        }
    }

    LaunchedEffect(viewModel.navState){

        when(val state = viewModel.navState){
            UsersScreenNavState.InitState -> {}
            is UsersScreenNavState.NavToInfoPopup -> {

                navController.navigate(BaseAppRoutes.BaseInfoPopup(actionText = state.actionText, state.text, state.img))
                viewModel.resetNavState()
            }
        }
    }


}