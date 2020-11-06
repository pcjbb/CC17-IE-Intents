package com.example.cc17_ie_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
    private fun openCamera() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("content://media/external/images/media/")
        startActivity(intent)
    }
    private fun openAlarm() {
        val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
        startActivity(intent)
    }

}