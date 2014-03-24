package com.enixer.pokeindivcalculator.individualcalculator;

import com.enixer.pokeindivcalculator.R;
import com.enixer.pokeindivcalculator.database.PokeStatDatabaseHelper;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IndividualCalculatorActivity extends Activity {
	private SQLiteDatabase database;
	static final String TABLE_NAME = "poke_base_stat";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		database = new PokeStatDatabaseHelper(getApplicationContext())
				.getReadableDatabase();
		setContentView(R.layout.individual_calculator);
	}

	public void searchPoke(View v) {
		EditText id = (EditText) findViewById(R.id.indiv_pokeid);
		EditText name = (EditText) findViewById(R.id.indiv_pokename);
		if (!id.getText().toString().equals("")) {
			String[] idnum = { id.getText().toString() };
			Cursor cursor = database.query(TABLE_NAME, null, "id = ?", idnum,
					null, null, null, null);
			cursor.moveToFirst();
			name.setText(cursor.getString(1));
		}
	}

}