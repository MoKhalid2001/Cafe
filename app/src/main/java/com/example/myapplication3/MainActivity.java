package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int counter_orders = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elements Vriables :
        Button plusButton = findViewById(R.id.plusBut);
        Button minusButton = findViewById(R.id.minusBut);
        Button orderButton = findViewById(R.id.orderBut);
        TextView orderNum = findViewById(R.id.OrderNumbers);
        EditText nameTxt = findViewById(R.id.nameText);
        CheckBox whCream = findViewById(R.id.CreamCheck);
        CheckBox Choclate = findViewById(R.id.ChocalateCheck);

        //Blus/Minus click actions :
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter_orders++;
                orderNum.setText(String.valueOf(counter_orders));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter_orders == 0)
                    Toast.makeText(getApplicationContext(),"You didn't order any thing !",Toast.LENGTH_SHORT).show();
                else {
                    counter_orders--;
                    orderNum.setText(String.valueOf(counter_orders));
                }
            }
        });

        //Order click action :
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orderDetails = "";
                int total_cost = 0 , cupCost = 5;
                String userName = nameTxt.getText().toString();
                if (userName.equals("")){
                    Toast.makeText(getApplicationContext(), "You didn't write your name !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!(whCream.isChecked() || Choclate.isChecked())) {
                    Toast.makeText(getApplicationContext(), "You didn't choose orders !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (counter_orders == 0) {
                    Toast.makeText(getApplicationContext(), "You didn't choose quantity !", Toast.LENGTH_SHORT).show();
                    return;
                }

                total_cost = cupCost * counter_orders;

                if (whCream.isChecked()) {
                    orderDetails += " Whipped Cream ";
                    total_cost += counter_orders * 2;
                }
                if (Choclate.isChecked()) {
                    orderDetails += " Chocalate ";
                    total_cost += counter_orders * 3;
                }
               // Toast.makeText(getApplicationContext(),"Hello, " + userName + " Your cost is " + total_cost,Toast.LENGTH_SHORT).show();
                Intent orderInent = new Intent(MainActivity.this,MainActivity2.class);
                orderInent.putExtra("UserName",userName);
                orderInent.putExtra("OrderCount" , counter_orders);
                orderInent.putExtra("OrderDetails",orderDetails);
                orderInent.putExtra("TotalCost",total_cost);

                startActivity(orderInent);
                /*
                // Creating intent for name :
                Intent orderIntent = new Intent(Intent.ACTION_SENDTO);

                // Sending an email :
                orderIntent.setData(Uri.parse("mailto:"));
                orderIntent.putExtra(Intent.EXTRA_EMAIL,"geekmido225@gmail.com");
                orderIntent.putExtra(Intent.EXTRA_SUBJECT,"Orderd for : " + userName);
                orderIntent.putExtra(Intent.EXTRA_TEXT,orderDetails);
                if (orderIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(orderIntent);
                    */

            }
        });


    }

}
