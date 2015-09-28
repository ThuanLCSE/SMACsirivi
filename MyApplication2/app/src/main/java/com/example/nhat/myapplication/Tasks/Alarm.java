package com.example.nhat.myapplication.Tasks;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.AlarmClock;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Calendar;

/**
 * Created by Nhat on 9/27/2015.
 */
public class Alarm {
    Context mContext;

    public Alarm(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void createAlarm(int a, int b) {

        Intent i = new Intent( AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, 10);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 10);
        i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        mContext.startActivity(i);

    }
}
