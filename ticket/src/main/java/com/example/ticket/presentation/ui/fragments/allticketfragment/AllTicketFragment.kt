package com.example.ticket.presentation.ui.fragments.allticketfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core_utils.SharedPref
import com.example.core_utils.base.BaseFragment
import com.example.ticket.R
import com.example.ticket.databinding.FragmentAllTicketBinding
import com.example.ticket.presentation.ui.fragments.allticketfragment.adapter.AllTicketsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTicketFragment : BaseFragment(R.layout.fragment_all_ticket) {

    private val binding by viewBinding(FragmentAllTicketBinding::bind)
    private val viewModel by viewModels<AllTicketsViewModel>()
    private val adapter = AllTicketsAdapter()
    private lateinit var sharedPref: SharedPref

    override fun initialize() {
        binding.rv.adapter = adapter
        viewModel.loadAllTickets()
        sharedPref = SharedPref(requireContext())

        val selectedName = sharedPref.selectedName
        val selectedUserCity = sharedPref.selectedUserCity ?: "Минск"

        if (selectedName != null && selectedUserCity != null) {
            binding.tvWhere.text = "$selectedUserCity-$selectedName"
        } else if (selectedName != null) {
            binding.tvWhere.text = selectedName
        } else {
            binding.tvWhere.text = selectedUserCity
        }

        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initSubscribers() {
        viewModel.allTickets.collectUIState(
            state = {
                binding.progressBar.visibility = View.VISIBLE
            },
            onSuccess = {
                binding.progressBar.visibility = View.GONE
                binding.constContainer.visibility = View.VISIBLE
                adapter.submitList(it.tickets)
            }
        )
    }
}