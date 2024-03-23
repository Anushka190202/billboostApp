package com.example.billboostapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.billboostapp.R
import com.example.billboostapp.databinding.ActivityLoginBinding
import com.example.billboostapp.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth
        binding.tvLogin.setOnClickListener {
            var intent= Intent(this, ActivityLoginBinding::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            val email=binding.etEmail.text.toString()
            val password=binding.etPassword.text.toString()
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{task->
                    if (task.isSuccessful){
                        val user=auth.currentUser
                        var intent= Intent(this,ActivityLoginBinding::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(baseContext,"Authentication failed!!"+task.exception, Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}