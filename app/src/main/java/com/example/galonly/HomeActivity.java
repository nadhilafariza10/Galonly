package com.example.galonly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button listbtn = (Button) findViewById(R.id.button1);

        listbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Intent btn1 = new Intent( HomeActivity.this, ListGalonActivity.class);
                    HomeActivity.this.startActivity(btn1);
                    finish();
            }
        });
    }
}