package com.example.android1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val name = findViewById<EditText>(R.id.editTextName)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val login = findViewById<Button>(R.id.btnLogin)
        login.setOnClickListener {
            val nameText = name.text.toString().trim()
            val passwordText = password.text.toString().trim()
            if(nameText.isEmpty() || passwordText.isEmpty()){
                Toast.makeText(this,"Please enter username and password", Toast.LENGTH_LONG).show()
            }
            else if (nameText  == "admin" && passwordText == "admin"){
                Toast.makeText(this,"Login Success 🎉🎉", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Invalid Username or Password", Toast.LENGTH_LONG).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}