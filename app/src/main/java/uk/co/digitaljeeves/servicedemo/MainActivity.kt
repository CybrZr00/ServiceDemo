package uk.co.digitaljeeves.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import uk.co.digitaljeeves.servicedemo.MyBackgroundService.Companion.MARKS
import uk.co.digitaljeeves.servicedemo.MyBackgroundService.Companion.NAME
import uk.co.digitaljeeves.servicedemo.MyBackgroundService.Companion.TAG
import uk.co.digitaljeeves.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME, "Barry")
        serviceIntent.putExtra(MARKS, 78)
        binding.apply {
            btnStart.setOnClickListener{
                Log.i(TAG, "Starting service...")
                startService(serviceIntent)
            }
            btnStop.setOnClickListener{
                Log.i(TAG, "Stopping Service...")
                stopService(serviceIntent)
            }
        }
    }
}