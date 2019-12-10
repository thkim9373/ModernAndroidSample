package com.example.modernandroidsample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import com.example.modernandroidsample.databinding.ActivityMainBinding;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        final AppDatabase db = Room.databaseBuilder(MainActivity.this, AppDatabase.class, "todo-db")
                .build();

        // UI update.
        db.todoDao().getAll().observe(MainActivity.this, todos -> binding.tvResult.setText(todos.toString()));

        Runnable runnable = () -> db.todoDao().insert(new Todo(binding.etInput.getText().toString()));

        Executor executor = Executors.newSingleThreadExecutor();

        // Insert data when click the button.
        binding.btAdd.setOnClickListener(view -> executor.execute(runnable));
    }
}
