package com.german.tareasapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.german.tareasapp.Constants;
import com.german.tareasapp.R;
import com.german.tareasapp.adapters.OnItemClickListener;
import com.german.tareasapp.adapters.TasksAdapter;
import com.german.tareasapp.models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TasksAdapter.OnTaskClickListener, OnItemClickListener<Task> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPreviousIntent();

        RecyclerView rvTasks = findViewById(R.id.rv_tasks);

        TasksAdapter tasksAdapter = new TasksAdapter(provideTasks());
        tasksAdapter.setTaskClickListener(this);
        tasksAdapter.setOnItemClickListener(this);

        rvTasks.setAdapter(tasksAdapter);

        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis tareas");
    }

    private List<Task> provideTasks() {
        Task task1 = new Task("Sacar la basura", "Germán");
        Task task2 = new Task("Visitar a la abuela", "Germán");
        Task task3 = new Task("Estudiar para el final", "Miryam");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        return tasks;
    }

    private void getPreviousIntent() {
        Intent loginIntent = getIntent();
        String email = loginIntent.getStringExtra(Constants.KEY_USER_EMAIL);
        String password = loginIntent.getStringExtra(Constants.KEY_USER_PASSWORD);
        //int age = loginIntent.getIntExtra("userAge", -1);

        Toast.makeText(this, email + " " + password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskClick(Task task) {
        //Toast.makeText(this, task.getTitle() + " asignado a: " + task.getAssignedTo(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Task item) {
        Toast.makeText(this, "Llamando desde generics: " + item.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_task) {
            startAddTaskActivity();
        } else if (item.getItemId() == R.id.action_logout) {
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences(Constants.CREDENTIALS_PREFERENCES, MODE_PRIVATE);
        preferences.edit()
                .clear()
                .apply();
        startActivity(new Intent(this, WelcomeActivity.class));
        finish();
    }

    private void startAddTaskActivity() {
        startActivity(new Intent(this, AddTaskActivity.class));
    }
}
