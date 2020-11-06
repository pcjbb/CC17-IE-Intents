package com.example.cc17_ie_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NextActivityFNL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_fnl)
        val username = getIntent().getStringExtra("username")
        if (username != null) {
            Toast.makeText(this, "Welcome, $username!", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.openBrowserBtn).setOnClickListener { openBrowser() }
        findViewById<Button>(R.id.openMessageBtn).setOnClickListener { openMessage() }
        findViewById<Button>(R.id.openAlarmBtn).setOnClickListener { openAlarm() }
        findViewById<Button>(R.id.openMapsBtn).setOnClickListener { openMaps() }
        findViewById<Button>(R.id.openCalendarBtn).setOnClickListener { openCalendar() }

    }

    private fun openBrowser() {
        Toast.makeText(this, "Opening browser", Toast.LENGTH_SHORT).show()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com/"))
        startActivity(intent)
    }
    private fun openMessage() {
        val sms_uri = Uri.parse("smsto:+639xxxxxxxxx")
        val sms_intent = Intent(Intent.ACTION_SENDTO, sms_uri)
        sms_intent.putExtra("sms_body", "Hello")
        startActivity(sms_intent)
    }
    private fun openAlarm() {
        val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
        startActivity(intent)
    }
    private fun openMaps(){
        //this is an intentional error in my case since no map application is installed in my device emulator
        val loc = "12.9538477,77.3507442"
        val addressUri = Uri.parse("geo:0,0?q=" + loc)
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No application found", Toast.LENGTH_SHORT).show()
        }
    }
    private fun openCalendar() {
        //the even will not work because of the lack of data
        val intent = Intent(CalendarContract.ACTION_HANDLE_CUSTOM_EVENT)
        intent.addCategory(Intent.CATEGORY_APP_CALENDAR)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Calendar failed to open because no event was specified.", Toast.LENGTH_SHORT).show()
            }
        }
    }
