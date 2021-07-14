package com.smatek.servicedemo

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

/**
 * @author: zhuw
 * Created by zhuwang 2021-05-28-星期五-下午4:47
 * Email zhuwang999@foxmail.com
 */
class TestSerVice : Service() {


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private val CHANNEL_ID_STRING = "TestSerVice"
    private val CHANNEL_ID_NAME = "测试后台"
    private val NOTIFICATION_ID = 1

    @SuppressLint("WrongConstant")
    private fun startForeground() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val mChannel: NotificationChannel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = NotificationChannel(
                CHANNEL_ID_STRING,
                CHANNEL_ID_NAME,
                NotificationManager.IMPORTANCE_LOW
            )
            notificationManager.createNotificationChannel(mChannel)
            val notification = Notification.Builder(
                applicationContext,
                CHANNEL_ID_STRING
            ).setPriority(NotificationManager.IMPORTANCE_NONE)
                .setDefaults(NotificationCompat.FLAG_ONLY_ALERT_ONCE).build()
            startForeground(
                NOTIFICATION_ID,
                notification
            )
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("zhuw","onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("zhuw","onCreate")
        startForeground()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zhuw","onDestroy")
        stopForeground(true)
    }


}