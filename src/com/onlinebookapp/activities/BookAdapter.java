package com.onlinebookapp.activities;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<Details> {

	private ArrayList<Details> detailsList;
	private Context mContext;

	public BookAdapter(Context mContext, ArrayList<Details> detailsList) {
		super(mContext,R.layout.item_book);

		this.detailsList = detailsList;
		this.mContext = mContext;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return detailsList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.item_book, null);

		ImageView name = (ImageView) view.findViewById(R.id.imageView1);
		Details details = detailsList.get(position);
		name.setImageResource(details.getImage());

		return view;
	}
}
