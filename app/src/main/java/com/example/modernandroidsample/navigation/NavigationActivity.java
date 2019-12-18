package com.example.modernandroidsample.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.modernandroidsample.R;
import com.example.modernandroidsample.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNavigationBinding binding = DataBindingUtil.setContentView(NavigationActivity.this, R.layout.activity_navigation);
    }
}
