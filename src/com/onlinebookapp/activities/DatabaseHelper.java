package com.onlinebookapp.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Logcat tag
	private static final String LOG = "DatabaseHelper";

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "book";

	// Table Names
	private static final String TABLE_BOOK_REGISTRATION = "book_registration";

	// Common Column names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PHONE = "phone";
	private static final String KEY_EMAIL = "email";

	// Column names for student registration
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_USERNAME = "username";
	private static final String KEY_PASSWORD = "password";

	// Table Create Statements
	// Todo table create statement
	private static final String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_BOOK_REGISTRATION + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PHONE + " TEXT," + KEY_EMAIL + " TEXT," + KEY_ADDRESS
			+ " TEXT," + KEY_USERNAME + " TEXT," + KEY_PASSWORD + " TEXT" + ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		db.execSQL(CREATE_TABLE_STUDENT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_STUDENT);

		// create new tables
		onCreate(db);
	}

	public long createStudentegistraton(Register register) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, register.getName());
		values.put(KEY_PHONE, register.getPhno());

		values.put(KEY_ADDRESS, register.getAddress());

		values.put(KEY_USERNAME, register.getUsername());
		values.put(KEY_PASSWORD, register.getPassowrd());
		values.put(KEY_EMAIL, register.getEmail());

		// insert row
		long todo_id = db.insert(TABLE_BOOK_REGISTRATION, null, values);

		return todo_id;
	}

	public Register getStudentLogin(String username, String password) {

		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT *FROM " + TABLE_BOOK_REGISTRATION + " WHERE " + KEY_USERNAME + "='" + username
				+ "' AND " + KEY_PASSWORD + "='" + password + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		Register register = new Register();
		if (c != null)
			c.moveToFirst();
		register.setSno(c.getString(c.getColumnIndex(KEY_ID)));
		register.setName(c.getString(c.getColumnIndex(KEY_NAME)));
		register.setPhno(c.getString(c.getColumnIndex(KEY_PHONE)));
		register.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));

		register.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
		register.setPassowrd(c.getString(c.getColumnIndex(KEY_PASSWORD)));
		register.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
		return register;
	}

	public Register getStudentLogin(String sno) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT *FROM " + TABLE_BOOK_REGISTRATION + " WHERE " + KEY_ID + "=" + sno;

		Cursor c = db.rawQuery(selectQuery, null);
		Register register = new Register();
		if (c != null)
			c.moveToFirst();
		register.setSno(c.getString(c.getColumnIndex(KEY_ID)));
		register.setName(c.getString(c.getColumnIndex(KEY_NAME)));
		register.setPhno(c.getString(c.getColumnIndex(KEY_PHONE)));
		register.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));

		register.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
		register.setPassowrd(c.getString(c.getColumnIndex(KEY_PASSWORD)));
		register.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
		return register;
	}

	public void updateTheValues(String id, String address, String phoneno, String email, String password) {

		String selectQuery = "UPDATE  " + TABLE_BOOK_REGISTRATION + " SET " + KEY_ADDRESS + "='" + address + "',"
				+ KEY_PHONE + "='" + phoneno + "'," + KEY_PASSWORD + "='" + password + "'," + KEY_EMAIL + "='" + email
				+ "' WHERE " + KEY_ID + "='" + id + "'";
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL(selectQuery);
	}

	public void deleteThevalue(String sno) {
		String selectQuery = "DELETE FROM " + TABLE_BOOK_REGISTRATION + " WHERE " + KEY_ID + "=" + sno;
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL(selectQuery);
	}
}
