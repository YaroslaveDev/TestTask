package com.pfv.abzagencytesttask.ext

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun String.convertToRequestBody() =
    this.toRequestBody("text/plain".toMediaTypeOrNull())