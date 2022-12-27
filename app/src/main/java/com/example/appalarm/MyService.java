package com.example.appalarm;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Calendar;

public class MyService extends Service {
    private MediaPlayer p;
    public MyService() {
    }



    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"Alarme ON ",Toast.LENGTH_SHORT).show();
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone r=RingtoneManager.getRingtone(getApplicationContext(),uri);
        r.play();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        p.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}