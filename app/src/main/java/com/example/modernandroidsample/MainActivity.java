package com.example.modernandroidsample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.modernandroidsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        MainViewModel viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);

        // UI update.
        viewModel.getAll().observe(MainActivity.this, todos -> binding.tvResult.setText(todos.toString()));

        // Insert data when click the button.
        binding.btAdd.setOnClickListener(view -> viewModel.insert(new Todo(binding.etInput.getText().toString())));
    }
}
