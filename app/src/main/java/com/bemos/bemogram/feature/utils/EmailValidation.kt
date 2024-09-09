package com.bemos.bemogram.feature.utils

import android.util.Patterns

fun emailValidation(
    email: String
) : Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}