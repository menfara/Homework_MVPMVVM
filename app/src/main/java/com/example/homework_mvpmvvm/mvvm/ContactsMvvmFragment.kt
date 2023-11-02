package com.example.homework_mvpmvvm.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_mvpmvvm.R
import com.example.homework_mvpmvvm.adapters.ContactsAdapter
import com.example.homework_mvpmvvm.databinding.FragmentContactsMvpBinding
import com.example.homework_mvpmvvm.databinding.FragmentContactsMvvmBinding
import com.example.homework_mvpmvvm.repository.ContactsRepositoryImpl


class ContactsMvvmFragment : Fragment() {
    private var _binding: FragmentContactsMvvmBinding? = null
    private val binding get() = _binding!!
    private val adapter: ContactsAdapter = ContactsAdapter()

    private val viewModel: ContactsViewModel = ContactsViewModel(ContactsRepositoryImpl())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsMvvmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.loadData()

        viewModel.contactsListLiveData.observe(viewLifecycleOwner) { contacts ->
            adapter.submitList(contacts)
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerViewContacts) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ContactsMvvmFragment.adapter
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

