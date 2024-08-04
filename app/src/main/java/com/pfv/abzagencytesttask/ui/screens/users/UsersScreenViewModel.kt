package com.pfv.abzagencytesttask.ui.screens.users

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.data.dto.UsersDto
import com.pfv.abzagencytesttask.data.dvo.UserDvo
import com.pfv.abzagencytesttask.data.dvo.UsersDvo
import com.pfv.abzagencytesttask.domain.ResultState
import com.pfv.abzagencytesttask.domain.use_case.GetAllUsersUseCase
import com.pfv.abzagencytesttask.ui.screens.users.nav_state.UsersScreenNavState
import com.pfv.abzagencytesttask.ui.screens.users.screen_state.UsersScreenState
import com.pfv.abzagencytesttask.ui.screens.users.ui_state.UsersScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersScreenViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase
) : ViewModel() {

    var uiState by mutableStateOf<UsersScreenUiState>(UsersScreenUiState.InitState)
    var screenState by mutableStateOf<UsersScreenState>(UsersScreenState.SetupState)
    var navState by mutableStateOf<UsersScreenNavState>(UsersScreenNavState.InitState)
    val users = mutableStateListOf<UserDvo>()

    fun getAllUsers(){

        viewModelScope.launch(Dispatchers.IO) {

            updateScreenState(UsersScreenState.SetupState)

            val result = getAllUsersUseCase()

            when(result){
                is ResultState.Error -> {

                    updateUiState(UsersScreenUiState.Error(result.errorDvo.errorMessage.toString()))
                    updateScreenState(UsersScreenState.EmptyState)
                }
                is ResultState.Success -> {

                    val data = result.data as UsersDvo

                    if (data.users.isEmpty()){
                        updateScreenState(UsersScreenState.EmptyState)
                    }else{
                        users.clear()
                        users.addAll(data.users)
                        updateScreenState(UsersScreenState.SuccessState)
                    }
                }
            }

        }
    }

    private fun updateUiState(state: UsersScreenUiState){
        uiState = state
    }

    private fun updateScreenState(state: UsersScreenState){
        screenState = state
    }

    fun updateNavState(state: UsersScreenNavState){
        navState = state
    }

    fun resetUiState() = updateUiState(UsersScreenUiState.InitState)
    fun resetNavState() = updateNavState(UsersScreenNavState.InitState)

}