package com.example.homework_mvpmvvm.repository

import com.example.homework_mvpmvvm.models.Contact

class ContactsRepositoryImpl : ContactsRepository {
    private var contactsList: List<Contact> = listOf()

    override fun getContactsList(): List<Contact> {
        return contactsList.ifEmpty { getRemoteContacts() }
    }

    private fun getRemoteContacts(): List<Contact> {
        val list: MutableList<Contact> = mutableListOf(
            Contact(0, "Alice Smith", "+1234567890", "alice.smith@example.com"),
            Contact(1, "Bob Johnson", "+1234567891", "bob.johnson@example.com"),
            Contact(2, "Carol Williams", "+1234567892", "carol.williams@example.com"),
            Contact(3, "David Anderson", "+1234567893", "david.anderson@example.com"),
            Contact(4, "Eva Lewis", "+1234567894", "eva.lewis@example.com"),
            Contact(5, "Frank Martinez", "+1234567895", "frank.martinez@example.com")
        )

        contactsList = list

        return list
    }
}