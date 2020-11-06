package com.example.cc17_ie_intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.loginBtn)
        val un = findViewById<TextInputEditText>(R.id.username)
        val pw = findViewById<TextInputEditText>(R.id.password)
        if (login != null && pw != null && un != null) {
            login.setOnClickListener {
                val username = un.text.toString()
                val password = pw.text.toString()
                if (username=="princess" && password=="123") {
                    goToNextAct()
                } else {
                    Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun goToNextAct() {
        val un = findViewById<TextInputEditText>(R.id.username)
        val intent = Intent(this, NextActivityFNL::class.java)
        intent.putExtra("username", un.getText().toString())
        startActivity(intent)
    }
}



