package com.german.tareasapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.german.tareasapp.Constants;
import com.german.tareasapp.R;
import com.german.tareasapp.adapters.TasksAdapter;
import com.german.tareasapp.models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPreviousIntent();

        RecyclerView rvTasks = findViewById(R.id.rv_tasks);

        TasksAdapter tasksAdapter = new TasksAdapter(provideTasks());
        rvTasks.setAdapter(tasksAdapter);

        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        /*
        List<String> otrosNombres = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        nombres.add("German");
        nombres.addAll(otrosNombres);
        String german = nombres.get(0);

        ListView -> RecyclerView (Adapter, ViewHolder, LayoutManager)

        1er nombre -> dibuja en pantalla
        2do nomnre -> dibuja en pantalla
        ..
        200 nombres ->
         */
    }

    private List<Task> provideTasks() {
        Task task1 = new Task("Sacar la basura", "Germán");
        Task task2 = new Task("Visitar a la abuela", "Germán");
        Task task3 = new Task("Estudiar para el final", "Miryam");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
        tasks.add(task3);
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
}