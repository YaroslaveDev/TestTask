package com.pfv.abzagencytesttask.data.dvo

data class ErrorDvo(
    val errorRes: Int? = null,
    val errorMessage: String? = null,
    val errorCode: String? = null
) {
    override fun toString(): String {
        return when {
            errorMessage != null -> errorMessage
            errorRes != null -> errorRes.toString()
            else -> ""
        }
    }
}