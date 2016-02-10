package com.team15.rohitslist;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;

public class DisplayVendorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_vendor_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        String message = intent.getStringExtra(buyerActivity.VENDOR_ID);
        TextView vendorName = (TextView) findViewById(R.id.vendorMenuName);
        vendorName.setText(message);

        TextView vendorAddress = (TextView) findViewById(R.id.vendorMenuAddress);

        String location = "SQLville, SQL 15213";
        vendorAddress.setText(location);

        //Programmatically fill in menu order options
        LinearLayout prices = (LinearLayout) findViewById(R.id.menuPrices);
        LinearLayout options = (LinearLayout) findViewById(R.id.menuOptions);
        LinearLayout amt = (LinearLayout) findViewById(R.id.menuAmount);
        final int menuOptions = 4; //getFromSQL()
        NumberFormat money = NumberFormat.getCurrencyInstance();
        int[] price = new int[menuOptions]; //getPricesFromSQL()
        for(int i = 0; i < menuOptions; i++) {
            String option = "getFromSQL.i" + i;
            TextView foodOption = new TextView(this);
            foodOption.setText(option);
            foodOption.setTextSize(20);
            foodOption.setTextColor(Color.BLACK);
            foodOption.setPadding(0, 16, 0, 16);
            options.addView(foodOption);

            TextView priceOption = new TextView(this);
            priceOption.setText(money.format(3.50)); //getFromSQL.p[i]
            priceOption.setTextSize(20);
            priceOption.setTextColor(Color.BLACK);
            priceOption.setPadding(0, 16, 0, 16);
            priceOption.setGravity(Gravity.CENTER);
            priceOption.setId(i + 1000);
            prices.addView(priceOption);

            EditText amount = new EditText(this);
            amount.setInputType(InputType.TYPE_CLASS_NUMBER);
            amount.setEms(5);
            amount.setTextColor(Color.BLACK);
            amount.setId(i + 2000);
            amount.setPadding(0, 16, 0, 16);
            amount.setGravity(Gravity.CENTER);
            amt.addView(amount);
            //    ((TextView) findViewById(R.id.text_result)).setText(format.format(result));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            int money = 0;
            @Override
            public void onClick(View view) {
                if(counter == 0) {
                    for(int i = 0; i < menuOptions; i++){
                        TextView temp_amt = (TextView)view.findViewById(i + 2000);
                        int temp_amt2 = Integer.parseInt(temp_amt.getText().toString());
                        TextView temp_price = (TextView)view.findViewById(i + 1000);
                        int temp_price2 = Integer.parseInt(temp_amt.getText().toString());
                        money = temp_amt2*temp_price2;
                    }
                    String total = "Your total is $" + money + ", press again to order";
                    Snackbar.make(view, total, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(view, "Order placed!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        header.addView(orderTotal);
    }

}
