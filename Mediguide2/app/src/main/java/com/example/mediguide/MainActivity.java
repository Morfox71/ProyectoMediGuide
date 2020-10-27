package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ingresarB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ingresarB = (Button) findViewById(R.id.btn_siguiente);
        this.ingresarB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, NavigationDrawer.class));
            }
        });


    }
}