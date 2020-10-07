package com.german.tareasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent loginIntent = getIntent();
        String email = loginIntent.getStringExtra(Constants.KEY_USER_EMAIL);
        String password = loginIntent.getStringExtra(Constants.KEY_USER_PASSWORD);
        //int age = loginIntent.getIntExtra("userAge", -1);

        Toast.makeText(this, email + " " + password, Toast.LENGTH_SHORT).show();
    }
}