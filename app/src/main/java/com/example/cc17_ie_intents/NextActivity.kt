package com.example.cc17_ie_intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val username = getIntent().getStringExtra("username")
        if (username != null) {
            Toast.makeText(this, "Welcome, $username!", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.openBrowserBtn).setOnClickListener { openBrowser() }
    }
    private fun openBrowser() {
        Toast.makeText(this, "Opening browser", Toast.LENGTH_SHORT).show()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com/"))
        startActivity(intent)
    }
}