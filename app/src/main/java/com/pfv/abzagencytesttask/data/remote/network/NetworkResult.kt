package com.pfv.abzagencytesttask.data.remote.network

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.pfv.abzagencytesttask.data.dto.ErrorDto
import com.pfv.abzagencytesttask.data.dvo.ErrorDvo
import com.pfv.abzagencytesttask.domain.ResultState
import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResult<T : Any?> {
    class Success<T : Any>(val data: T?) : NetworkResult<T>()
    class Error<T : Any>(val code: Int, val message: String?) : NetworkResult<T>()
    class Exception<T : Any>(val e: Throwable) : NetworkResult<T>()
}

fun <T : Any> handleApi(
    execute: () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful) {
            NetworkResult.Success(body)
        } else {
            val errorDto = Gson().fromJson(response.errorBody()?.charStream(), ErrorDto::class.java)
            NetworkResult.Error(code = errorDto.code ?: response.code(), message = errorDto.message)
        }
    } catch (e: HttpException) {
        NetworkResult.Error(code = e.code(), message = e.message())
    } catch (e: JsonSyntaxException) {
        NetworkResult.Error(code = 404, message = "Something went wrong")
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}

fun <T : Any?, R : Any> NetworkResult<T>.toResultState(executable: (T?) -> R?): ResultState<R> {
    return when (this) {
        is NetworkResult.Success -> ResultState.Success(executable(data))
        is NetworkResult.Error -> ResultState.Error(
            ErrorDvo(
                errorCode = code.toString(),
                errorMessage = message
            )
        )

        is NetworkResult.Exception -> ResultState.Error(
            ErrorDvo(
                errorMessage = e.message
            )
        )
    }
}