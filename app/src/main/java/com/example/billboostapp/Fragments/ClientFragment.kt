package com.example.billboostapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billboostapp.Adapters.ClientAdapter
import com.example.billboostapp.DataModels.Clients
import com.example.billboostapp.R
import com.example.billboostapp.databinding.FragmentClientBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class ClientFragment : Fragment() {
    lateinit var binding: FragmentClientBinding
    var db = Firebase.firestore
    lateinit var clientAdapter: ClientAdapter
    var clientList = ArrayList<Clients>()

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
        var layoutManager = LinearLayoutManager(requireContext())
        binding.rvClients.layoutManager= layoutManager

        var clientList = arrayListOf<Clients>()
        clientAdapter = ClientAdapter(clientList)
        val docRef = db.collection("clients")
        docRef.get().addOnSuccessListener {documents->
            binding.loader.hide()
            for (document in documents) {
                var client = document.toObject<Clients>()
                client.id = document.id
                clientList.add(client)
                Toast.makeText(requireContext(), "${document.id} => ${document.data}", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "${document.id} => ${document.data}")
            }
            clientAdapter.notifyDataSetChanged()
            binding.rvClients.adapter= clientAdapter
        }.addOnFailureListener {
            Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
            Log.e("exception in firebase", it.message.toString())
        }
        return binding.root
    }

}