package com.german.tareasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Mis tareas");
        }
        */
        getSupportActionBar().setTitle("Mis tareas");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_task) {
            Toast.makeText(this, "Agregando tarea", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.action_logout) {
            Toast.makeText(this, "Cerrando sesión", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}