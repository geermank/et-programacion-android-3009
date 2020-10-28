package com.german.tareasapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.german.tareasapp.Constants;
import com.german.tareasapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private CheckBox cbRememberCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        cbRememberCredentials = findViewById(R.id.cb_remember_credentials);

        btnLogin.setOnClickListener(this);

        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Iniciando sesión", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aca
                Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            login();
        }
    }

    private void login() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Faltan datos por completar", Toast.LENGTH_SHORT).show();
            return;
        }

        saveUserCredentials(email, password);

        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.putExtra(Constants.KEY_USER_EMAIL, email);
        mainIntent.putExtra(Constants.KEY_USER_PASSWORD, password);
        startActivity(mainIntent);
        finish();
    }

    private void saveUserCredentials(String email, String password) {
        if (!cbRememberCredentials.isChecked()) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(Constants.KEY_USER_EMAIL, email)
                .putString(Constants.KEY_USER_PASSWORD, password)
                .apply();
    }
}