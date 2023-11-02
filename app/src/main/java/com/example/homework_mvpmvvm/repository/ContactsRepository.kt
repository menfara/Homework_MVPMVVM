package com.example.homework_mvpmvvm.repository

import com.example.homework_mvpmvvm.models.Contact

interface ContactsRepository {
    fun getContactsList(): List<Contact>
}