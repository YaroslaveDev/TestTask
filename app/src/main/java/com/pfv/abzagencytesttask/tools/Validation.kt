package com.pfv.abzagencytesttask.tools

import java.util.regex.Pattern

val EMAIL_ADDRESS_PATTERN = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)

fun isEmailValid(email: String): Boolean{
    return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
}

fun isValidUkrainianPhoneNumber(phoneNumber: String): Boolean {

    val regex = "^\\+38 \\(\\d{3}\\) \\d{3} - \\d{2} - \\d{2}$"
    val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(phoneNumber)

    return matcher.matches()
}