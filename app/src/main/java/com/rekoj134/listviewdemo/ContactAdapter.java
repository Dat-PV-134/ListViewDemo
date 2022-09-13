package com.rekoj134.listviewdemo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    List<ContactDemo> contactDemoList;

    public ContactAdapter(List<ContactDemo> contactDemoList) {
        this.contactDemoList = contactDemoList;
    }

    @Override
    public int getCount() {
        return contactDemoList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactDemoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        @SuppressLint("ViewHolder") View v = layoutInflater.inflate(R.layout.icon_contact, viewGroup, false);

        TextView tvName = v.findViewById(R.id.tvName);
        TextView tvPhone = v.findViewById(R.id.tvPhone);
        ImageView imageView = v.findViewById(R.id.imgContact);

        ContactDemo contactDemo = contactDemoList.get(i);

        tvName.setText(contactDemo.getName());
        tvPhone.setText(String.valueOf(contactDemo.getPhoneNumber()));
        if (!contactDemo.isImg()) {
            //imageView.setImageResource(R.mipmap.ic_contact_default);
            imageView.setVisibility(View.INVISIBLE);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }

        return v;
    }
}
