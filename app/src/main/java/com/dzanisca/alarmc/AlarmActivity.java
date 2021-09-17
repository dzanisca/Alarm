package com.dzanisca.alarmc;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmActivity extends AppCompatActivity {

    Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alarm);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(this, notification);
        if(ringtone == null){
            notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            ringtone = RingtoneManager.getRingtone(this, notification);
        }
    }

    @Override
    protected void onDestroy() {
        if(ringtone != null | ringtone.isPlaying()){
            ringtone.stop();
        }
        super.onDestroy();
    }
}