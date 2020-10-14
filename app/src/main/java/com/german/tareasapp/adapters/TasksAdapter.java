package com.german.tareasapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.german.tareasapp.R;
import com.german.tareasapp.models.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private List<Task> tasks;

    public TasksAdapter(@NonNull List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemTaskView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(itemTaskView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bind(tasks.get(position));
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvAssignedTo;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_task_title);
            tvAssignedTo = itemView.findViewById(R.id.tv_task_assigned_to);
        }

        public void bind(Task task) {
            tvTitle.setText(task.getTitle());
            tvAssignedTo.setText(task.getAssignedTo());
        }
    }

}
