package com.bemos.bemogram.data.firebase.hash_password

import androidx.compose.runtime.Composable
import java.security.MessageDigest

fun hashSha(password: String) : String {
    val md = MessageDigest.getInstance("SHA-256")
    val bytes = password.toByteArray()
    val digest = md.digest(bytes)
    return digest.fold("") { str, it -> str + "%02x".format(it) }
}