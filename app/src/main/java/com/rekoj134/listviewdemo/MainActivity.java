package com.rekoj134.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    List<ContactDemo> contactDemoList;
    ContactDemo contact01, contact02, contact03, contact04, contact05;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lvContact);
        btnAdd = findViewById(R.id.btnAdd);

        contactDemoList = new ArrayList<>();

        contact01 = new ContactDemo("Android", 130402, false);
        contact02 = new ContactDemo("IOS", 111111, false);
        contact03 = new ContactDemo("Unity", 222222, true);
        contact04 = new ContactDemo("PHP", 333333, false);
        contact05 = new ContactDemo("Flutter", 444444, true);

        contactDemoList.add(contact01);
        contactDemoList.add(contact02);
        contactDemoList.add(contact03);
        contactDemoList.add(contact04);
        contactDemoList.add(contact05);

        ContactAdapter contactAdapter = new ContactAdapter(contactDemoList);

        lvContact.setAdapter(contactAdapter);

        Intent intent = new Intent(getBaseContext(), AddContactActivity.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("KeyName", "Android Studio");
                intent.putExtra("Check", true);

                startActivity(intent);
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("PhoneNumber", contactDemoList.get(i).getPhoneNumber());
                intent.putExtra("Check", false);

                startActivity(intent);
            }
        });
    }
}