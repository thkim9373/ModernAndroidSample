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
    private LiveData<List<Todo>> todoList;
    public String newTodo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db").build();
        todoList = getAll();
    }

    public void insert(String title) {
        Runnable runnable = () -> db.todoDao().insert(new Todo(title));
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }

    LiveData<List<Todo>> getAll() {
        return db.todoDao().getAll();
    }

    public LiveData<List<Todo>> getTodoList() {
        return todoList;
    }

    public void setNewTodo(String newTodo) {
        this.newTodo = newTodo;
    }

    public String getNewTodo() {
        return newTodo;
    }
}
