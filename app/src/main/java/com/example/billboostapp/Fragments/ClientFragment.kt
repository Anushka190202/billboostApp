package com.example.billboostapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.billboostapp.R
import com.example.billboostapp.databinding.FragmentClientBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class ClientFragment : Fragment() {
    lateinit var binding:FragmentClientBinding
    var db= Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentClientBinding.inflate(layoutInflater)
        binding.fbAdd.setOnClickListener {
            findNavController().navigate(R.id.addClient)
        }




    return binding.root
    }

}