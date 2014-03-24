package com.enixer.pokeindivcalculator.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PokeStatDatabaseHelper extends SQLiteOpenHelper {
	static final String DATABASE_NAME = "poke_database.db";
	static final String TABLE_NAME_BASE_STAT = "poke_base_stat";
	static final int DATABASE_VERSION = 1;
	private static AssetManager assetmanager;
	private static InputStream inputstream;
	private static Scanner scanner;

	public PokeStatDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		assetmanager = context.getAssets();
		try {
			inputstream = assetmanager.open("PokeStatData.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner = new Scanner(inputstream);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createBaseStatDB(db);
	}

	private void createBaseStatDB(SQLiteDatabase db) {
		String[] columns = scanner.next().split(",");
		if (columns.length == 9) {
			String query = "create table " + TABLE_NAME_BASE_STAT + "("
					+ columns[0] + " int, " + columns[1] + " nvarchar, "
					+ columns[2] + " int, " + columns[3] + " int, "
					+ columns[4] + " int, " + columns[5] + " int, "
					+ columns[6] + " int, " + columns[7] + " int, "
					+ columns[8] + " int);";
			db.execSQL(query);
			while (scanner.hasNext()) {
				String[] values = scanner.next().split(",");
				ContentValues contentvalues = new ContentValues();
				for (int i = 0; i < 9; i++) {
					if (i != 1) {
						contentvalues.put(columns[i],
								Integer.parseInt(values[i]));
					} else {
						contentvalues.put(columns[i], values[i]);
					}
				}
				db.insert(TABLE_NAME_BASE_STAT, null, contentvalues);
			}
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
