package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActvity extends Activity {
	private Button  books,products;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_books);
		books=(Button)findViewById(R.id.books);
		products=(Button)findViewById(R.id.other_product);
		
		books.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActvity.this,
						BookListActivity.class);
				startActivity(intent);
			}
		});
	products.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActvity.this,
						CategoriesActivity.class);
				startActivity(intent);
			}
		});
}

}
