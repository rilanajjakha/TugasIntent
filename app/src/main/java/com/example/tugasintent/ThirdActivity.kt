package com.example.tugasintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasintent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menerima data dari SecondActivity
        val username = intent.getStringExtra("EXTRA_USERNAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val gender = intent.getStringExtra("EXTRA_GENDER")

        // menampilkan data
        binding.textViewUsername.text = "Username : $username"
        binding.textViewEmail.text = "Email : $email"
        binding.textViewPhone.text = "Phone : $phone"
        binding.textViewGender.text = "Gender : $gender"
    }
}