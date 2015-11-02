package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CartActivity extends Activity{
	Button payment,back;
	Details details;
	TextView price;
	ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
	  payment = (Button)findViewById(R.id.cartpayment);
	  back = (Button)findViewById(R.id.cart_back_button1);
	  iv = (ImageView)findViewById(R.id.cart_imageView);
	  price = (TextView)findViewById(R.id.cart_price);
	  
	  details = (Details)getIntent().getSerializableExtra("detail");
	  iv.setImageResource(details.getImage());
	  price.setText(details.getPrice());
	  
	  back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent bdetails = new Intent(getApplicationContext(), BookDetailsActivity.class);
		    bdetails.putExtra("detail", details);
			startActivity(bdetails);
		}
	});
	  payment.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent payment = new Intent(getApplicationContext(), PaymentActivity.class);
			payment.putExtra("detail", details);
			startActivity(payment);
		}
	});
	}

}
