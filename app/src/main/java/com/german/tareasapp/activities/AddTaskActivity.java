package com.german.tareasapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.LruCache;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.german.tareasapp.R;
import com.german.tareasapp.database.LocalDatabase;
import com.german.tareasapp.database.TasksDao;
import com.german.tareasapp.models.Task;

public class AddTaskActivity extends AppCompatActivity {

    private EditText etTitle, etOwner;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle = findViewById(R.id.et_title);
        etOwner = findViewById(R.id.et_assign_to);
        btnSave = findViewById(R.id.btn_save);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.add_task);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTask();
            }
        });
    }

    private void saveTask() {
        String title = etTitle.getText().toString();
        String owner = etOwner.getText().toString();

        Task newTask = new Task(title, owner);

        LocalDatabase localDatabase = LocalDatabase.getInstance(this);
        TasksDao tasksDao = localDatabase.getTasksDao();
        tasksDao.insert(newTask);

        Toast.makeText(this, "Tarea guardada!", Toast.LENGTH_SHORT).show();
        etTitle.setText("");
        etOwner.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            showConfirmationAlert();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showConfirmationAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atención")
                .setMessage("Esta tarea no se guardará")
                .setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
