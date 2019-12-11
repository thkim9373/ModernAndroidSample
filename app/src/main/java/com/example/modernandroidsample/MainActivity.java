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
        binding.setLifecycleOwner(MainActivity.this);

        MainViewModel viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
    }
}
