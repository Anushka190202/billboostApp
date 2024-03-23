package com.example.billboostapp.Activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.billboostapp.DataModels.Clients
import com.example.billboostapp.databinding.ActivityAddInvoiceBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class AddInvoice : AppCompatActivity() {
    lateinit var binding: ActivityAddInvoiceBinding
    lateinit var auth: FirebaseAuth
    var arrayList = ArrayList<Clients>()
    var db = Firebase.firestore
    lateinit var arrayAdapter: ArrayAdapter<Clients>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this,android.R
            .layout.simple_list_item_1,arrayList)
        binding.spClient.adapter = arrayAdapter

    }
}