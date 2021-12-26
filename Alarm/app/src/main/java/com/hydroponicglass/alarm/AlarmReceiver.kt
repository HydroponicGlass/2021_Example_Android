package com.hydroponicglass.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class AlarmReceiver : BroadcastReceiver() {

    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("log2", "enter onReceive")
        if(intent.action == "android.intent.action.BOOT_COMPLETED"){
            // Alarm Manager는 재부팅하면 초기화 되어서 여기에 세팅 해줘야 함
            Log.d("log2", "System Reboot")

            /*  alarm cancel    */
            alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

            alarmIntent = Intent(context, AlarmReceiver::class.java).let { intent ->
                PendingIntent.getBroadcast(context, 0, intent, 0)
            }

            alarmMgr?.cancel(alarmIntent)
            /*  alarm re register   */

            // Set the alarm to start at 8:30 a.m.
            val calendar: Calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, 21)
                set(Calendar.MINUTE, 19)
            }

            // setRepeating() lets you specify a precise custom interval--in this case,
            // 20 minutes.
            alarmMgr?.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,1000 * 60 * 1,
                alarmIntent
            )

        }
    }
}