package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent getter = getIntent();
        String username = getter.getStringExtra("UserName");
        int OrderCount = getter.getIntExtra("OrderCount",0);
        int TotalCost = getter.getIntExtra("TotalCost",0);
        String OrderDetails = getter.getStringExtra("OrderDetails");
        TextView txtview = findViewById(R.id.txtview1);
        String message= "Customer : " + username + " Orderd " + OrderCount + " Cups, With : " + OrderDetails + " With total cost : " + TotalCost;
        txtview.setText(message);

    }
}