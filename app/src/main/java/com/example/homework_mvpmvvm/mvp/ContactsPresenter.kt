package com.example.homework_mvpmvvm.mvp

import com.example.homework_mvpmvvm.models.Contact
import com.example.homework_mvpmvvm.repository.ContactsRepository
import com.example.homework_mvpmvvm.repository.ContactsRepositoryImpl

class ContactsPresenter(
    private val view: ContactsScreen.View
) : ContactsScreen.Presenter {
    private val repository: ContactsRepository = ContactsRepositoryImpl()

    override fun loadData() {
        val data = repository.getContactsList()
        view.showContacts(data)
    }

    override fun openContactDetails(contact: Contact) {
        view.showMessage(contact.phoneNumber)
    }
}
