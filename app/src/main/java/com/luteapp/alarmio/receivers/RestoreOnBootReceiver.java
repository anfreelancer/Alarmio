package com.luteapp.alarmio.receivers;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.luteapp.alarmio.Alarmio;
import com.luteapp.alarmio.data.AlarmData;
import com.luteapp.alarmio.data.TimerData;

public class RestoreOnBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Alarmio alarmio = (Alarmio) context.getApplicationContext();
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        for (AlarmData alarm : alarmio.getAlarms()) {
            if (alarm.isEnabled)
                alarm.set(context, manager);
        }

        for (TimerData timer : alarmio.getTimers()) {
            if (timer.getRemainingMillis() > 0)
                timer.setAlarm(context, manager);
        }
    }
}
