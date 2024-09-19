package com.example.tugasintent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate dipanggil")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // button listener
        binding.buttonRegister.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val email = binding.editTextEmail.text.toString()
            val phone = binding.editTextPhone.text.toString()
            val password = binding.editTextPassword.text.toString()
            val gender = if (binding.radioMale.isChecked) "Male" else "Female"

            // validasi
            if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (!binding.checkBox.isChecked) {
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            } else {
                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra("EXTRA_USERNAME",username)
                    putExtra("EXTRA_EMAIL", email)
                    putExtra("EXTRA_PHONE", phone)
                    putExtra("EXTRA_GENDER", gender)
                    putExtra("EXTRA_PASSWORD", password)
                }
                startActivity(intentToSecondActivity)
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause dipanggil")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy dipanggil")
    }
}