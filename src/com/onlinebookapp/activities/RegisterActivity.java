package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterActivity  extends Activity{
	Button register,bactoLogin;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		register = (Button)findViewById(R.id.register);
		bactoLogin = (Button)findViewById(R.id.gobacktologin);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(login);
			}
		});
	bactoLogin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent login = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(login);
		}
	});

		}

}
