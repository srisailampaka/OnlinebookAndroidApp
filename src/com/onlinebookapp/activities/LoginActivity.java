package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentlogin);
		editid = (EditText) findViewById(R.id.fname_et);
		editpassword = (EditText) findViewById(R.id.pwd_et);

		loginButton = (Button) findViewById(R.id.login_sl);
		registerButton = (Button) findViewById(R.id.register);
		registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);

			}
		});

		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				username = editid.getText().toString().trim();
				password = editpassword.getText().toString().trim();
				if (username.equalsIgnoreCase("book") && password.equalsIgnoreCase("12345")) {
					Intent intent = new Intent(LoginActivity.this, MainActvity.class);
					startActivity(intent);
					editid.setText("");
					editpassword.setText("");
				} else {
					Toast.makeText(getApplicationContext(), "Pleae check the credentials", Toast.LENGTH_LONG).show();
				}
			}
		});

	}
}
