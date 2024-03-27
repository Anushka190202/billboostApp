package com.example.billboostapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.billboostapp.databinding.ActivityInvoiceTemplateBinding
import java.util.Calendar

class InvoiceTemplate : AppCompatActivity() {
    lateinit var binding:ActivityInvoiceTemplateBinding
    private var year = 0
    private var month = 0
    private var day = 0
    private lateinit var calendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvoiceTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}