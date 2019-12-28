package com.example.implicitintent71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EveningActivity extends AppCompatActivity {

    Intent intent;
    TextView textEveningTime;
    SimpleDateFormat sdf1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);

        initView();
    }

    private void initView() {
        Button buttonEveningSync = findViewById(R.id.buttonEveningSync);
        sdf1 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String time = sdf1.format(new Date());
        textEveningTime = findViewById(R.id.textEveningTime);
        textEveningTime.setText(time);

        buttonEveningSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("HHmm", Locale.getDefault());
                int currentTime = Integer.parseInt(sdf.format(new Date()));
                intent = new Intent(Intent.ACTION_SYNC);
                String message;
                if (currentTime >= 600 && currentTime < 1400) {
                    message = "http://morning";
                    intent.setData(Uri.parse(message));
                    startActivity(intent);
                } else if (currentTime >=1400 && currentTime <= 1500) {
                    message = "http://afternoon";
                    intent.setData(Uri.parse(message));
                    startActivity(intent);
                } else {
                    message = "http://evening";
                    intent.setData(Uri.parse(message));
                    startActivity(intent);
                }
            }
        });
    }
}