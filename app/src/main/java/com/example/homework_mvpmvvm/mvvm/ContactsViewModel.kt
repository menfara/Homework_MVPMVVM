package com.example.homework_mvpmvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework_mvpmvvm.models.Contact
import com.example.homework_mvpmvvm.repository.ContactsRepository

class ContactsViewModel(
    private val repository: ContactsRepository
) : ViewModel() {

    private val _contactsListLiveData = MutableLiveData<List<Contact>>()
    val contactsListLiveData: LiveData<List<Contact>> = _contactsListLiveData

    fun loadData() {
        val data = repository.getContactsList()
        _contactsListLiveData.postValue(data)
    }
}