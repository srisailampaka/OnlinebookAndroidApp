package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	Button register, bactoLogin, delete;
	EditText username, password, name, phone, email, address;
	private SharedPreferences prefs;
	int id;
	Register details;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		prefs = getSharedPreferences("univer", MODE_PRIVATE);
		name=(EditText)findViewById(R.id.name_et);
		address=(EditText)findViewById(R.id.address_et);
		phone=(EditText)findViewById(R.id.phone_et);
		email=(EditText)findViewById(R.id.email_et);
		username=(EditText)findViewById(R.id.username_et);
		password=(EditText)findViewById(R.id.password_et);
		
		register = (Button)findViewById(R.id.register);
		delete = (Button)findViewById(R.id.delete);
		bactoLogin = (Button)findViewById(R.id.gobacktologin);
		if(getIntent()!=null&&getIntent().getExtras()!=null)
		{
		id=	getIntent().getExtras().getInt("id");
		}
		if(id==0){
			username.setEnabled(true);
			name.setEnabled(true);
			delete.setVisibility(View.GONE);
			register.setText("Register");
			
		}else{
		 details = (new DatabaseHelper(getApplicationContext())).getStudentLogin(prefs.getString("id", "0"));
		
		name.setText(details.getName());
		address.setText(details.getAddress());
		phone.setText(details.getPhno());
		email.setText(details.getEmail());
		username.setText(details.getUsername());
		password.setText(details.getPassowrd());
		username.setEnabled(false);
		name.setEnabled(false);
		delete.setVisibility(View.VISIBLE);
		register.setText("Update");
		
		}
		
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				(new DatabaseHelper(getApplicationContext())).deleteThevalue(details.getSno());
				Toast.makeText(getApplicationContext(), "Deleted successfully", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(id==0)
				{Register register=new Register();
				register.setAddress(address.getText().toString().trim());
				register.setEmail(email.getText().toString().trim());
				register.setPassowrd(password.getText().toString().trim());
				register.setPhno(phone.getText().toString().trim());
				register.setUsername(username.getText().toString().trim());
				register.setName(name.getText().toString().trim());
				(new DatabaseHelper(getApplicationContext())).createStudentegistraton(register);
				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(login);}
				else if(id==1){
					(new DatabaseHelper(getApplicationContext())).updateTheValues(details.getSno(), 
							address.getText().toString().trim(),details.getPhno(),email.getText().toString().trim(), password.getText().toString().trim());
					Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_LONG).show();
				}
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
