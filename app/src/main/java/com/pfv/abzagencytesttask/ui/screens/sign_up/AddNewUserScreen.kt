package com.pfv.abzagencytesttask.ui.screens.sign_up

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.ui.common.buttons.BaseAppButton
import com.pfv.abzagencytesttask.ui.common.buttons.BaseAppTextButton
import com.pfv.abzagencytesttask.ui.common.input.BaseAppInputField
import com.pfv.abzagencytesttask.ui.common.items.SelectableITPositionItem
import com.pfv.abzagencytesttask.ui.common.other.InfoScreen
import com.pfv.abzagencytesttask.ui.common.other.PickImageBottomSheet
import com.pfv.abzagencytesttask.ui.common.other.SelectImageField
import com.pfv.abzagencytesttask.ui.navigation.routes.BaseAppRoutes
import com.pfv.abzagencytesttask.ui.screens.sign_up.event.AddNewUserEvent
import com.pfv.abzagencytesttask.ui.screens.sign_up.ui_state.AddNewUserUiState
import com.pfv.abzagencytesttask.ui.theme.Black_87
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewUserScreen(
    navController: NavController,
    viewModel: AddNewUserViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.create_new_user),
                        color = Black_87,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            )
        }

    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(it)
                .padding(horizontal = 16.dp)
                .imePadding(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            BaseAppInputField(
                keyboardActions = KeyboardActions(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = stringResource(id = R.string.your_name),
                supportingText = stringResource(id = R.string.required_field),
                error = viewModel.form.nameError,
                value = viewModel.form.name,
                onValueChanged = {
                    viewModel.reduceEvent(AddNewUserEvent.UpdateName(it))
                }
            )

            BaseAppInputField(
                keyboardActions = KeyboardActions(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = stringResource(id = R.string.email),
                supportingText = stringResource(id = R.string.invalid_email),
                error = viewModel.form.emailError,
                value = viewModel.form.email,
                onValueChanged = {
                    viewModel.reduceEvent(AddNewUserEvent.UpdateEmail(it))
                }
            )

            BaseAppInputField(
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = stringResource(id = R.string.phone),
                supportingText = stringResource(id = R.string.required_field),
                error = viewModel.form.phoneError,
                value = viewModel.form.phone,
                onValueChanged = {
                    viewModel.reduceEvent(AddNewUserEvent.UpdatePhone(it))
                }
            )
            
            Text(
                text = stringResource(id = R.string.select_your_position),
                color = Black_87,
                style = MaterialTheme.typography.bodyMedium
            )

            viewModel.form.availablePositions.forEach {

                val isSelected by remember(viewModel.form.position) {
                    derivedStateOf {
                        viewModel.form.position == it
                    }
                }

                SelectableITPositionItem(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    isSelected = isSelected,
                    text = it.name,
                    onSelect = {
                        viewModel.reduceEvent(AddNewUserEvent.UpdateITPosition(it))
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                SelectImageField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    error = viewModel.form.imageError,
                    value = viewModel.form.getImageName(),
                )

                BaseAppTextButton(
                    modifier = Modifier
                        .padding(
                            horizontal = 10.dp
                        ),
                    text = stringResource(id = R.string.upload)
                ) {
                    viewModel.reduceEvent(AddNewUserEvent.ShowPickImageBottomSheet)
                    focusManager.clearFocus()
                    keyboardController?.hide()

                }
            }


            BaseAppButton(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                text = stringResource(id = R.string.sign_up)
            ) {
                viewModel.reduceEvent(AddNewUserEvent.OnSignUp(context = context))
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        }

        when(val state = viewModel.uiState){
            AddNewUserUiState.InitState -> {}
            AddNewUserUiState.PickImageBottomSheet -> {

                PickImageBottomSheet(
                    onDismiss = {
                        viewModel.resetUiState()
                    },
                    onImgPicked = {
                        viewModel.reduceEvent(AddNewUserEvent.OnImagePicked(it))
                        viewModel.resetUiState()
                    }
                )
            }

            AddNewUserUiState.UserSuccessCreated -> {

                InfoScreen(
                    actionText = stringResource(id = R.string.got_it),
                    text = stringResource(id = R.string.user_registration_success),
                    img = R.drawable.img_user_successfully_registered,
                    onAction = {
                        viewModel.resetUiState()
                        navController.navigate(BaseAppRoutes.UsersScreen){
                            popUpTo(0)
                        }
                    },
                    onCloseInfoScreen = {
                        viewModel.resetUiState()
                        navController.navigate(BaseAppRoutes.UsersScreen){
                            popUpTo(0)
                        }
                    }
                )
            }

            is AddNewUserUiState.Error -> {
                InfoScreen(
                    actionText = stringResource(id = R.string.got_it),
                    text = state.text,
                    img = R.drawable.img_email_already_registered,
                    onAction = {
                        viewModel.resetUiState()
                    },
                    onCloseInfoScreen = {
                        viewModel.resetUiState()
                    }
                )
            }
            AddNewUserUiState.Setup -> {

                Dialog(
                    onDismissRequest = {},
                    properties = DialogProperties(usePlatformDefaultWidth = false)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}