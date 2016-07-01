package com.example.quanthumleap.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button but_notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_notify = (Button)findViewById(R.id.but_notify);
        but_notify.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                Notification.Builder builder = new Notification.Builder(MainActivity.this);

                builder.setTicker("Ticker");
                builder.setContentTitle("Content Title");
                builder.setContentText("Content text");

                //builder.setSmallIcon();
                builder.setContentIntent(pIntent).getNotification();
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });

    }
}
