package com.example.modernandroidsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel {

    private AppDatabase db;

    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db").build();
    }

    void insert(Todo todo) {
        Runnable runnable = () -> db.todoDao().insert(todo);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }

    LiveData<List<Todo>> getAll() {
        return db.todoDao().getAll();
    }
}
