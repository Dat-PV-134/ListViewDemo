package com.rekoj134.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddContactActivity extends AppCompatActivity {
    TextView tvNameAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        tvNameAdd = findViewById(R.id.tvNameAdd);

        Intent intent = getIntent();

        Boolean isAdd = intent.getBooleanExtra("Check", false);

        if (isAdd) {
            String name = intent.getStringExtra("KeyName");
            tvNameAdd.setText(name);
        } else {
            int phoneNumber = intent.getIntExtra("PhoneNumber", 0);
            tvNameAdd.setText(String.valueOf(phoneNumber));
        }
    }
}