package com.rekoj134.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    List<ContactDemo> contactDemoList;
    ContactDemo contact01, contact02, contact03, contact04, contact05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lvContact);

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
    }
}