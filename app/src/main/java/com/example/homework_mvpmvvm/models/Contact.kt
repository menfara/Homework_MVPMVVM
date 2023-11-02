package com.example.homework_mvpmvvm.models

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val email: String? = null
)
