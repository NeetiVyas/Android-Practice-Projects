package com.example.neerja_modi_school;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.neerja_modi_school.databinding.FeesBinding;

public class FeesActivity extends BaseActivity {
    FeesBinding feesBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feesBinding = FeesBinding.inflate(getLayoutInflater());
        setContentView(feesBinding.getRoot());
    }
}