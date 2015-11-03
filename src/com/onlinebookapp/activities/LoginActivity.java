package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private Button loginButton, registerButton;
	private EditText editid;
	private EditText editpassword;
	private String username, password;
	SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentlogin);
		 editor = getSharedPreferences("univer", MODE_PRIVATE).edit();
		editid = (EditText) findViewById(R.id.fname_et);
		editpassword = (EditText) findViewById(R.id.pwd_et);

		loginButton = (Button) findViewById(R.id.login_sl);
		registerButton = (Button) findViewById(R.id.register);
		registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				intent.putExtra("id", 0);
				startActivity(intent);

			}
		});

		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					
					Register student = (new DatabaseHelper(getApplicationContext()))
							.getStudentLogin(editid.getText().toString(), editpassword.getText().toString());
					if (student != null) {
						editor.putString("id", student.getSno());
						 editor.commit();
						 
						 editid.setText("");
						 editpassword.setText("");
						Intent intent = new Intent(LoginActivity.this, MainActvity.class);
						startActivity(intent);
					} else {
						Toast.makeText(getApplicationContext(), "plese check the login Details", Toast.LENGTH_LONG).show();
					}
				} catch (CursorIndexOutOfBoundsException e) {
					Toast.makeText(getApplicationContext(), "plese check the login Details", Toast.LENGTH_LONG).show();
				}
				
			}
		});

	}
}
