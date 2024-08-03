package com.pfv.abzagencytesttask.ui.screens.sign_up

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.ui.common.buttons.BaseAppButton
import com.pfv.abzagencytesttask.ui.common.input.BaseAppInputField
import com.pfv.abzagencytesttask.ui.common.items.SelectableITPositionItem
import com.pfv.abzagencytesttask.ui.common.other.PickImageBottomSheet
import com.pfv.abzagencytesttask.ui.common.other.SelectImageField
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

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),

    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(bottom = it.calculateBottomPadding())
                .padding(horizontal = 16.dp)
                .imePadding(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            BaseAppInputField(
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

            ITPosition.entries.forEach {

                val isSelected by remember(viewModel.form.position) {
                    derivedStateOf {
                        viewModel.form.position == it
                    }
                }

                SelectableITPositionItem(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    isSelected = isSelected,
                    text = stringResource(id = it.text),
                    onSelect = {
                        viewModel.reduceEvent(AddNewUserEvent.UpdateITPosition(it))
                    }
                )
            }

            SelectImageField(
                modifier = Modifier
                    .fillMaxWidth(),
                error = null,
                value = "",
                onUploadImage = {
                    viewModel.reduceEvent(AddNewUserEvent.ShowPickImageBottomSheet)
                }
            )

            BaseAppButton(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                text = stringResource(id = R.string.sign_up)
            ) {
                viewModel.reduceEvent(AddNewUserEvent.OnSignUp)
            }
        }

        when(viewModel.uiState){
            AddNewUserUiState.InitState -> {}
            AddNewUserUiState.PickImageBottomSheet -> {

                PickImageBottomSheet(
                    onPickCameraImg = {
                        viewModel.resetUiState()
                    },
                    onPickGalleryImg = {
                        viewModel.resetUiState()
                    },
                    onDismiss = {
                        viewModel.resetUiState()
                    }
                )
            }
        }
    }
}