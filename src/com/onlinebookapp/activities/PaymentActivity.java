package com.onlinebookapp.activities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class PaymentActivity extends Activity {
	Button payment,back;
	DatePickerDialog datePickerDialog;
	SimpleDateFormat dateFormatter;
	private EditText etExprire;
	Details details;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);
        payment = (Button)findViewById(R.id.payment_pay);
        back = (Button)findViewById(R.id.payment_go_back);
        etExprire = (EditText)findViewById(R.id.exp_date);
        
        details = (Details)getIntent().getSerializableExtra("detail");
        
        etExprire.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				datePickerDialog.show();
				return false;
			}
		});
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        payment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thanq = new Intent(getApplicationContext(), ThankyouActivity.class);
				startActivity(thanq);
			}
		});
        back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent cart = new Intent(getApplicationContext(), CartActivity.class);
				cart.putExtra("detail", details);
				startActivity(cart);
			}
		});
	
	datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

		   public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		    Calendar newDate = Calendar.getInstance();
		    newDate.set(year, monthOfYear, dayOfMonth);
		    etExprire.setText(dateFormatter.format(newDate.getTime()));
		   }

		  }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

}
}
