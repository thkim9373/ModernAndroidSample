package com.example.modernandroidsample.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.modernandroidsample.R;
import com.example.modernandroidsample.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNavigationBinding binding = DataBindingUtil.setContentView(NavigationActivity.this, R.layout.activity_navigation);

        NavController navController = Navigation.findNavController(NavigationActivity.this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(NavigationActivity.this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(NavigationActivity.this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
