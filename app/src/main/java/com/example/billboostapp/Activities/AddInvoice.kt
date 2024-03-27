package com.example.billboostapp.Activities

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.billboostapp.DataModels.Clients
import com.example.billboostapp.databinding.ActivityAddInvoiceBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddInvoice : AppCompatActivity() {
    lateinit var binding: ActivityAddInvoiceBinding
    lateinit var auth: FirebaseAuth
    var arrayList = ArrayList<Clients>()
    var db = Firebase.firestore
    lateinit var arrayAdapter: ArrayAdapter<Clients>
    private var year = 0
    private var month = 0
    private var day = 0
    private lateinit var calendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvDate.setOnClickListener {
            title = "KotlinApp"
            calendar = Calendar.getInstance()
            year = calendar.get(Calendar.YEAR)
            month = calendar.get(Calendar.MONTH)
            day = calendar.get(Calendar.DAY_OF_MONTH)
            val dialog = DatePickerDialog(this, { _, year, month, day_of_month ->
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = month + 1
                calendar[Calendar.DAY_OF_MONTH] = day_of_month
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                binding.tvDate.text = sdf.format(calendar.time)
            }, calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH])
            dialog.datePicker.minDate = calendar.timeInMillis
            calendar.add(Calendar.YEAR, 0)
            dialog.datePicker.maxDate = calendar.timeInMillis
            dialog.show()
        }

    }
}