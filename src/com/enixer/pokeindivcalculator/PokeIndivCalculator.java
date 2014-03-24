package com.enixer.pokeindivcalculator;

import com.enixer.pokeindivcalculator.database.PokeStatDatabaseHelper;
import com.enixer.pokeindivcalculator.menu.MenuActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class PokeIndivCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poke_indiv_calculator);
		initializeDatabase();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Intent intent = new Intent(PokeIndivCalculator.this, MenuActivity.class);
		startActivity(intent);
		finish();
	}

	private void initializeDatabase() {
		PokeStatDatabaseHelper helper = new PokeStatDatabaseHelper(getApplicationContext());
		SQLiteDatabase database = helper.getReadableDatabase();
		database.close();
	}
}
