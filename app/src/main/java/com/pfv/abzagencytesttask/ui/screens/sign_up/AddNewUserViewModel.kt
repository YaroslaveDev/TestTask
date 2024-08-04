package com.pfv.abzagencytesttask.ui.screens.sign_up

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.data.dto.CreateNewUserRequestDto
import com.pfv.abzagencytesttask.data.dto.Token
import com.pfv.abzagencytesttask.domain.ResultState
import com.pfv.abzagencytesttask.domain.use_case.CreateNewUserUseCase
import com.pfv.abzagencytesttask.domain.use_case.GetUserCreationTokenUseCase
import com.pfv.abzagencytesttask.ext.convertToRequestBody
import com.pfv.abzagencytesttask.ext.isNull
import com.pfv.abzagencytesttask.tools.fileFromContentUri
import com.pfv.abzagencytesttask.tools.isEmailValid
import com.pfv.abzagencytesttask.tools.isValidUkrainianPhoneNumber
import com.pfv.abzagencytesttask.ui.screens.sign_up.event.AddNewUserEvent
import com.pfv.abzagencytesttask.ui.screens.sign_up.form.AddNewUserForm
import com.pfv.abzagencytesttask.ui.screens.sign_up.ui_state.AddNewUserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class AddNewUserViewModel @Inject constructor(
    private val getUserCreationTokenUseCase: GetUserCreationTokenUseCase,
    private val createNewUserUseCase: CreateNewUserUseCase
) : ViewModel() {

    var form by mutableStateOf(AddNewUserForm())
    var uiState by mutableStateOf<AddNewUserUiState>(AddNewUserUiState.InitState)
    var isRealtimeValidationActive by mutableStateOf(false)

    fun reduceEvent(event: AddNewUserEvent) {

        when (event) {
            is AddNewUserEvent.UpdateEmail -> updateEmail(event.text)
            is AddNewUserEvent.UpdateITPosition -> updateITPosition(event.position)
            is AddNewUserEvent.UpdateName -> updateName(event.text)
            is AddNewUserEvent.UpdatePhone -> updatePhone(event.text)
            AddNewUserEvent.ShowPickImageBottomSheet -> updateUiState(AddNewUserUiState.PickImageBottomSheet)
            is AddNewUserEvent.OnSignUp -> signUp(event.context)
            is AddNewUserEvent.OnImagePicked -> updateImage(event.img)
        }
    }

    private fun updateImage(uri: Uri){

        form = form.copy(
            image = uri
        )

        if (isRealtimeValidationActive){
            validateImage()
        }
    }

    private fun getUserCreationToken(context: Context) {

        viewModelScope.launch(Dispatchers.IO) {

            updateUiState(AddNewUserUiState.Setup)

            val response = getUserCreationTokenUseCase()

            when (response) {
                is ResultState.Error -> {
                    updateUiState(AddNewUserUiState.Error(response.errorDvo.errorMessage.orEmpty()))
                }

                is ResultState.Success -> {

                    val data = response.data as Token

                    createNewUser(context, data.token.orEmpty())
                }
            }
        }
    }

    private suspend fun createNewUser(context: Context, token: String) {

        val file = form.image?.fileFromContentUri(context)
        val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), file!!)
        val photo = MultipartBody.Part.createFormData("photo", file.name, requestFile)

        val response = createNewUserUseCase(
            token = token,
            name = form.name.convertToRequestBody(),
            email = form.email.convertToRequestBody(),
            phone = form.phone.convertToRequestBody(),
            positionId = "1".convertToRequestBody(),
            photo = photo
        )

        when(response){
            is ResultState.Error -> {
                updateUiState(AddNewUserUiState.Error(response.errorDvo.errorMessage.orEmpty()))
            }
            is ResultState.Success -> {
                updateUiState(AddNewUserUiState.UserSuccessCreated)
            }
        }
    }

    private fun updateUiState(state: AddNewUserUiState) {
        uiState = state
    }

    fun resetUiState() = updateUiState(AddNewUserUiState.InitState)

    private fun signUp(context: Context) {

        isRealtimeValidationActive = true
        validateAllFields()

        if (form.isAllFieldsValid()) {
            getUserCreationToken(context)
        }
    }

    private fun validateAllFields() {
        validateName()
        validatePhone()
        validateEmail()
        validateImage()
    }

    private fun updateEmail(text: String) {

        form = form.copy(
            email = text
        )

        if (isRealtimeValidationActive) validateEmail()
    }

    private fun updateITPosition(position: ITPosition) {

        form = form.copy(
            position = position
        )
    }

    private fun updateName(text: String) {

        form = form.copy(
            name = text
        )

        if (isRealtimeValidationActive) validateName()
    }

    private fun updatePhone(text: String) {

        form = form.copy(
            phone = text
        )

        if (isRealtimeValidationActive) validatePhone()
    }

    private fun validateEmail() {
        form = form.copy(
            emailError =
            if (form.email.isBlank()) R.string.required_field
            else if (!isEmailValid(form.email)) R.string.invalid_email else null
        )
    }

    private fun validateImage(){
        form = form.copy(
            imageError = if (form.image.isNull()) R.string.required_field else null
        )
    }

    private fun validateName() {
        form = form.copy(
            nameError = if (form.name.isBlank()) R.string.required_field else null
        )
    }

    private fun validatePhone() {
        form = form.copy(
            phoneError =
            if (form.phone.isBlank()) R.string.required_field else null
        )
    }
}
