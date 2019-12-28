package com.example.implicitintent71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button buttonSync = findViewById(R.id.buttonSync);

        buttonSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("HHmm", Locale.getDefault());
                int currentTime = Integer.parseInt(sdf.format(new Date()));
                intent = new Intent(Intent.ACTION_SYNC);
                String message;
                if (currentTime >= 600 && currentTime < 1400) {
                    message = "http://morning";
                } else if (currentTime >=1400 && currentTime <= 1500) {
                    message = "http://afternoon";
                } else {
                    message = "http://evening";
                }
                intent.setData(Uri.parse(message));
                startActivity(intent);
            }
        });
    }
}
