package com.example.homework_mvpmvvm.mvp

import com.example.homework_mvpmvvm.models.Contact

sealed interface ContactsScreen {
    interface View {
        fun showMessage(message: String)
        fun showContacts(list: List<Contact>)
    }

    interface Presenter {
        fun loadData()
        fun openContactDetails(contact: Contact)
    }
}
