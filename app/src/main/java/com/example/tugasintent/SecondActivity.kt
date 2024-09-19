package com.example.tugasintent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasintent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"

    private lateinit var binding: ActivitySecondBinding

    private var registeredEmail : String? = null
    private var registeredPassword : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate dipanggil")

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registeredEmail = intent.getStringExtra("EXTRA_EMAIL")
        registeredPassword = intent.getStringExtra("EXTRA_PASSWORD")

        Log.d(TAG, "Registered Email: $registeredEmail, Registered Password: $registeredPassword")

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // validasi
            if (email == registeredEmail && password == registeredPassword) {
                val profileIntent = Intent(this@SecondActivity, ThirdActivity::class.java).apply {
                    putExtra("EXTRA_USERNAME", intent.getStringExtra("EXTRA_USERNAME"))
                    putExtra("EXTRA_EMAIL", intent.getStringExtra("EXTRA_EMAIL"))
                    putExtra("EXTRA_PHONE", intent.getStringExtra("EXTRA_PHONE"))
                    putExtra("EXTRA_GENDER", intent.getStringExtra("EXTRA_GENDER"))
                }
                startActivity(profileIntent)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
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