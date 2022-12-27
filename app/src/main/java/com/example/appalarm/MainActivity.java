package com.example.appalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button b1 , b2 ;
    EditText e1 , e2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.music);
        Intent i1=new Intent(getApplicationContext(),MyService.class);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int v1 = Integer.parseInt(e1.getText().toString());
                int v2 = Integer.parseInt(e2.getText().toString());
                if (e1.getText().toString()!=null && e2.getText().toString()!=null){
                    if(v1>=0 && v2>=0){
                        Toast.makeText(getApplicationContext(),"Alarme done ",Toast.LENGTH_LONG).show();
                        AlarmManager a=(AlarmManager)getSystemService(ALARM_SERVICE);
                        PendingIntent p=PendingIntent.getService(getApplicationContext(),0,i1,0);
                        Calendar c=Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,v1);
                        c.set(Calendar.MINUTE,v2);
                        c.set(Calendar.SECOND,00);
                        a.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),0,p);
                    }else{
                        Toast.makeText(getApplicationContext(),"Valeurs non valide !!!!! ",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Erreur dans les zones de text !!!!! ",Toast.LENGTH_LONG).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(i1);
            }
        });
    }
}