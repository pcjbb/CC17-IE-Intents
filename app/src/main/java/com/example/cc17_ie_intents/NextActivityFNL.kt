package com.example.cc17_ie_intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast

class NextActivityFNL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_fnl)
        val username = getIntent().getStringExtra("username")
        if (username != null) {
            Toast.makeText(this, "Welcome, $username!", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.openBrowserBtn).setOnClickListener { openBrowser() }
        findViewById<Button>(R.id.openGalleryBtn).setOnClickListener { openCamera() }
        findViewById<Button>(R.id.openAlarmBtn).setOnClickListener { openAlarm() }
        findViewById<Button>(R.id.openMapsBtn).setOnClickListener { openMaps() }
    }

    private fun openBrowser() {
        Toast.makeText(this, "Opening browser", Toast.LENGTH_SHORT).show()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com/"))
        startActivity(intent)
    }
    private fun openCamera() {
        Toast.makeText(this, "Opening ", Toast.LENGTH_SHORT).show()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("content://media/external/images/media/")
        startActivity(intent)
    }
    private fun openAlarm() {
        val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
        startActivity(intent)
    }
    private fun openMaps(){
        val loc = "12.9538477,77.3507442"

        val addressUri = Uri.parse("geo:0,0?q=" + loc)
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "No application found", Toast.LENGTH_SHORT).show()
        }
    }
}