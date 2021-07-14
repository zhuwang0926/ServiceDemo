package com.smatek.servicedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.d("zhuw","2222222222")
    }

    override fun onStart() {
        super.onStart()
        Log.d("zhuw","333333333")
    }
}