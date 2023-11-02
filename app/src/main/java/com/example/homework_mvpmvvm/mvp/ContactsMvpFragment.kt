package com.example.homework_mvpmvvm.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_mvpmvvm.R
import com.example.homework_mvpmvvm.adapters.ContactsAdapter
import com.example.homework_mvpmvvm.databinding.FragmentContactsMvpBinding
import com.example.homework_mvpmvvm.models.Contact


class ContactsMvpFragment : Fragment(), ContactsScreen.View {
    private lateinit var binding: FragmentContactsMvpBinding
    private val adapter: ContactsAdapter = ContactsAdapter()
    private lateinit var presenter: ContactsScreen.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactsMvpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ContactsPresenter(this)
        presenter.loadData()

        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewContacts.adapter = adapter

        adapter.click = {
            presenter.openContactDetails(it)
        }

        binding.btnNext.setOnClickListener {
            val action = ContactsMvpFragmentDirections.actionContactsMvpFragmentToContactsMvvmFragment()
            findNavController().navigate(action)
        }

    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showContacts(list: List<Contact>) {
        adapter.submitList(list)
    }
}
