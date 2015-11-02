package com.onlinebookapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThankyouActivity extends Activity {
	Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thanku);
	     back = (Button)findViewById(R.id.thankq_back);
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
