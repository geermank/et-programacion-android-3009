package com.german.tareasapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.german.tareasapp.Constants;
import com.german.tareasapp.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView tvAppName = findViewById(R.id.tv_app_name);
        // getString(R.string.mensaje_bienvenida)
        tvAppName.setText(R.string.mensaje_bienvenida);

        tvAppName.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        verifyIfUserLogged();
    }

    private void verifyIfUserLogged() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(Constants.KEY_USER_EMAIL, null);
        String password = sharedPreferences.getString(Constants.KEY_USER_PASSWORD, null);

        if (email != null && password != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
