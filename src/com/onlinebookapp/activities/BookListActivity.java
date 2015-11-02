package com.onlinebookapp.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;

public class BookListActivity extends Activity {
	GridView grid;
	Button morebooks,back;
    public static  ArrayList<Details>detailsList;
    public static int getpositionimage;
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book);
		grid = (GridView)findViewById(R.id.gridbooks);
		morebooks = (Button)findViewById(R.id.morebooks);
		back = (Button)findViewById(R.id.goback);
		morebooks.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent blist = new Intent(getApplicationContext(), BookDetailsActivity.class);
//				startActivity(blist);
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent blist = new Intent(getApplicationContext(), MainActvity.class);
				
				startActivity(blist);
			}
		});
		detailsList = proresult();
		grid.setAdapter(new BookAdapter(getApplicationContext(), detailsList));
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Details detail = detailsList.get(position);
				Intent blist = new Intent(getApplicationContext(), BookDetailsActivity.class);
				blist.putExtra("detail", detail);
				startActivity(blist);

			}
		});
	}

	private ArrayList<Details> proresult() {
		// TODO Auto-generated method stub
		ArrayList<Details>result = new ArrayList<Details>();
		int[]  Images = {R.drawable.c,R.drawable.dotnet,R.drawable.dbms,R.drawable.java,
				R.drawable.advancejava,R.drawable.hadoop,R.drawable.hibernet,R.drawable.oracle,
	    		R.drawable.sap,R.drawable.servelets,R.drawable.webtechnology};
		
			Details pack1= new Details();
			pack1.setAuthor("Balagurusamy");
			pack1.setName("Tata McGraw-Hill Education");
			pack1.setPrice("$20");
			pack1.setImage(Images[0]);
			result.add(pack1);
			
			Details pack2= new Details();
			pack2.setAuthor("John Hubbard");
			pack2.setName("Programming with C++");
			pack2.setPrice("$25");
			pack2.setImage(Images[1]);
			result.add(pack2);
			
			
			
			Details pack3= new Details();
			pack3.setAuthor("SEEMA KEDAR");
			pack3.setName("DATABASE MANAGEMENT SYSTEM");
			pack3.setPrice("$20");
			pack3.setImage(Images[2]);
			result.add(pack3);
			
			Details pack4= new Details();
			pack4.setAuthor("Denial Liang");
			pack4.setName("Object Oriented System With Java");
			pack4.setPrice("$22");
			pack4.setImage(Images[3]);
			result.add(pack4);
			
			Details pack5= new Details();
			pack5.setAuthor("Balaguruswamy");
			pack5.setName(" Programming with Java ");
			pack5.setPrice("$25");
			pack5.setImage(Images[4]);
			result.add(pack5);
			
			Details pack6= new Details();
			pack6.setAuthor("Tom White");
			pack6.setName("The Definitive Guide");
			pack6.setPrice("$25");
			pack6.setImage(Images[5]);
			result.add(pack6);
			
			Details pack7= new Details();
			pack7.setAuthor("Balaguruswamy");
			pack7.setName("Springs and hibernate frame work");
			pack7.setPrice("$15");
			pack7.setImage(Images[6]);
			result.add(pack7);
			
			Details pack8= new Details();
			pack8.setAuthor("Diana Lorentz");
			pack8.setName("Oracle Database SQL Reference, 10g Release 2");
			pack8.setPrice("$20");
			pack8.setImage(Images[7]);
			result.add(pack8);
			
			Details pack9= new Details();
			pack9.setAuthor("Glynn Williams");
			pack9.setName("SAP ERP Sales & Distribution ");
			pack9.setPrice("$22");
			pack9.setImage(Images[8]);
			result.add(pack9);
			
			Details pack10= new Details();
			pack10.setAuthor("Balgurswami");
			pack10.setName("Java Servlet Technology");
			pack10.setPrice("$25");
			pack10.setImage(Images[9]);
			result.add(pack10);
			
			Details pack11= new Details();
			pack11.setAuthor("Balgurswami");
			pack11.setName("Web Technology");
			pack11.setPrice("$25");
			pack11.setImage(Images[10]);
			result.add(pack11);
		
		return result;
	}

}