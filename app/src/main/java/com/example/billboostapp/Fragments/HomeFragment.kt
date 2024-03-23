package com.example.billboostapp.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billboostapp.Activities.AddInvoice
import com.example.billboostapp.Adapters.InvoiceAdapter
import com.example.billboostapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        binding.rvInvoice.layoutManager=LinearLayoutManager(requireContext())
        var names= listOf<String>("Name 1","Name 2","Name 3")
        var adapter = InvoiceAdapter(names)
        binding.rvInvoice.adapter=adapter
        binding.fbAdd.setOnClickListener{
            var intent= Intent(this@HomeFragment.requireContext(),AddInvoice::class.java)
            startActivity(intent)

        }
        return binding.root
    }

}