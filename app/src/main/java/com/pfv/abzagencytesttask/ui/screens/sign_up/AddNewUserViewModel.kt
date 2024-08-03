package com.pfv.abzagencytesttask.ui.screens.sign_up

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.tools.isEmailValid
import com.pfv.abzagencytesttask.tools.isValidUkrainianPhoneNumber
import com.pfv.abzagencytesttask.ui.screens.sign_up.event.AddNewUserEvent
import com.pfv.abzagencytesttask.ui.screens.sign_up.form.AddNewUserForm
import com.pfv.abzagencytesttask.ui.screens.sign_up.ui_state.AddNewUserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNewUserViewModel @Inject constructor() : ViewModel() {

    var form by mutableStateOf(AddNewUserForm())
    var uiState by mutableStateOf<AddNewUserUiState>(AddNewUserUiState.InitState)
    var isRealtimeValidationActive by mutableStateOf(true)

    fun reduceEvent(event: AddNewUserEvent) {

        when(event){
            is AddNewUserEvent.UpdateEmail -> updateEmail(event.text)
            is AddNewUserEvent.UpdateITPosition -> updateITPosition(event.position)
            is AddNewUserEvent.UpdateName -> updateName(event.text)
            is AddNewUserEvent.UpdatePhone -> updatePhone(event.text)
            AddNewUserEvent.ShowPickImageBottomSheet -> updateUiState(AddNewUserUiState.PickImageBottomSheet)
            AddNewUserEvent.OnSignUp -> signUp()
        }
    }

    private fun updateUiState(state: AddNewUserUiState){
        uiState = state
    }

    fun resetUiState() = updateUiState(AddNewUserUiState.InitState)

    private fun signUp(){

        isRealtimeValidationActive = true
        validateAllFields()

        if (form.isAllFieldsValid()){

        }
    }

    private fun validateAllFields(){
        validateName()
        validatePhone()
        validateEmail()
    }

    private fun updateEmail(text: String){

        form = form.copy(
            email = text
        )

        if (isRealtimeValidationActive) validateEmail()
    }

    private fun updateITPosition(position: ITPosition){

        form = form.copy(
            position = position
        )
    }

    private fun updateName(text: String){

        form = form.copy(
            name = text
        )

        if (isRealtimeValidationActive) validateName()
    }

    private fun updatePhone(text: String){

        form = form.copy(
            phone = text
        )

        if (isRealtimeValidationActive) validatePhone()
    }

    private fun validateEmail(){
        form = form.copy(
            emailError =
            if (form.email.isBlank()) R.string.required_field
            else if(!isEmailValid(form.email)) R.string.invalid_email else null
        )
    }

    private fun validateName(){
        form = form.copy(
            nameError = if (form.name.isBlank()) R.string.required_field else null
        )
    }

    private fun validatePhone(){
        form = form.copy(
            phoneError =
            if (form.phone.isBlank()) R.string.required_field else null
        )
    }
}
