package com.smatek.servicedemo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smatek.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTest.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(Intent(this,TestSerVice::class.java))
            }else{
                startService(Intent(this,TestSerVice::class.java))
            }
//            Log.d("zhuw","1111111111")
//            startActivity(Intent(this,MainActivity2::class.java))
        }
        binding.btnStop.setOnClickListener {
            stopService(Intent(this,TestSerVice::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this,TestSerVice::class.java))
    }
}