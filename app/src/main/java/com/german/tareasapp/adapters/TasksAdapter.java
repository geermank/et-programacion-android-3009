package com.german.tareasapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.german.tareasapp.R;
import com.german.tareasapp.models.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    public interface OnTaskClickListener {
        void onTaskClick(Task task);
    }

    private List<Task> tasks;
    private OnTaskClickListener taskClickListener;
    private OnItemClickListener<Task> onItemClickListener;

    public TasksAdapter(@NonNull List<Task> tasks) {
        this.tasks = tasks;
    }

    public void update(List<Task> updatedTasks) {
        tasks.clear();
        tasks.addAll(updatedTasks);
        notifyDataSetChanged();
    }

    public void setTaskClickListener(OnTaskClickListener taskClickListener) {
        this.taskClickListener = taskClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener<Task> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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

        public void bind(final Task task) {
            tvTitle.setText(task.getTitle());
            tvAssignedTo.setText(task.getAssignedTo());

            if (task.isClosed()) {
                tvTitle.setTextColor(ContextCompat.getColor(tvTitle.getContext(), R.color.colorPrimaryDark));
            } else {
                tvTitle.setTextColor(ContextCompat.getColor(tvTitle.getContext(), R.color.colorAccent));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (taskClickListener != null) {
                        taskClickListener.onTaskClick(task);
                    }
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(task);
                    }
                }
            });
        }
    }

}
