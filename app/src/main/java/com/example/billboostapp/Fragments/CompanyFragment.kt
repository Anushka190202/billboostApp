package com.example.billboostapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.billboostapp.R
import com.example.billboostapp.databinding.FragmentCompanyBinding

class CompanyFragment : Fragment() {
    lateinit var binding: FragmentCompanyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCompanyBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        binding.fbAdd.setOnClickListener{
           findNavController().navigate(R.id.addCompany)
        }
        return binding.root
    }
}

