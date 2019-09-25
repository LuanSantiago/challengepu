package com.pu.challengepu.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pu.challengepu.R
import com.pu.challengepu.viewmodel.ListOfferViewModel

class ListOfferFragment : Fragment() {

    companion object {
        fun newInstance() = ListOfferFragment()
    }

    private lateinit var viewModel: ListOfferViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_offer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListOfferViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
