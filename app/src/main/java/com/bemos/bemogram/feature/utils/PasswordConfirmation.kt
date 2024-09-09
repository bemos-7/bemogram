package com.bemos.bemogram.feature.utils

fun passwordConfirmation(
    password: String,
    passwordConfirm: String
) : Boolean {
    return password == passwordConfirm && password.isNotEmpty() && passwordConfirm.isNotEmpty()
}