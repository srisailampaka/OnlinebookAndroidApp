package com.onlinebookapp.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailsActivity extends Activity {
	Button cart,back;
	Details details;
	TextView Name,Author,Price;
	ImageView bookimage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bookdetails);
	 cart = (Button)findViewById(R.id.addtocart);
	 back = (Button)findViewById(R.id.bookdetailsback);
	 
	 details=(Details) getIntent().getSerializableExtra("detail");
	 
	 Name = (TextView)findViewById(R.id.bookdetails_Bookname);
	 Author = (TextView)findViewById(R.id.bookdetails_author);
	 Price = (TextView)findViewById(R.id.bookdetails_price);
	 bookimage = (ImageView)findViewById(R.id.bookdetails_image);
	 
	 Author.setText("Author:"+details.getAuthor());
	 Name.setText(details.getName());
	 Price.setText("Price:"+details.getPrice());
	 bookimage.setImageResource(details.getImage());
	 cart.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent payment = new Intent(getApplicationContext(), CartActivity.class);
			payment.putExtra("detail", details);
			startActivity(payment);
		}
	});
	 back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent blist = new Intent(getApplicationContext(), BookListActivity.class);
			startActivity(blist);
		}
	});

	}

}
