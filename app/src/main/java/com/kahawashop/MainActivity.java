package com.kahawashop;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    TextView noOfCoffee;
    Button plus, minus;
    TextView orderTextView;

    int no_coffee = 0, price_cup = 50, total_price = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noOfCoffee = findViewById(R.id.titletwo);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        orderTextView = findViewById(R.id.orderAmount);

    }

    public void btnMinus(View view) {

        if (no_coffee <= 0) {
            Toast.makeText(getApplicationContext(), "no order", Toast.LENGTH_LONG).show();
        } else {
            no_coffee--;
            total_price = no_coffee * price_cup;
            noOfCoffee.setText("" + no_coffee);
            Toast.makeText(getApplicationContext(), "Total price of " + no_coffee + "cups is" + no_coffee * price_cup, Toast.LENGTH_LONG).show();
            String orderText = "your order:" + total_price;
            orderTextView.setText(orderText);
        }
    }

    public void btnPlus(View view) {

        no_coffee++;
        total_price = no_coffee * price_cup;
        noOfCoffee.setText("" + no_coffee);

        Toast.makeText(getApplicationContext(), "Total price of " + no_coffee + "cups is" + no_coffee * price_cup, Toast.LENGTH_LONG).show();

        String orderText = "your order:Ksh" + total_price;
        orderTextView.setText(orderText);


    }

    public void btnOrder(View view){


        total_price =no_coffee * price_cup;
        noOfCoffee.setText("" + no_coffee);

        Toast.makeText(getApplicationContext(), "Total price of "+ no_coffee +"cups is"+no_coffee * price_cup,Toast.LENGTH_LONG).show();

        String orderText = "your order:Ksh"+total_price;
        orderTextView.setText(orderText);

    }

    public void emailing(){
        String [] cups={"winfredmueni.02@gmail.com"};
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL,cups);
        intent.putExtra(Intent.EXTRA_SUBJECT,"coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT,total_price);
        if(intent.resolveActivity(getPackageManager())!=null){
            //startActivity(intent);

            myRef.setValue("Hello, World!");
        }
    }













}
