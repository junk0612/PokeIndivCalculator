package com.enixer.pokeindivcalculator.menu;

import com.enixer.pokeindivcalculator.R;
import com.enixer.pokeindivcalculator.individualcalculator.IndividualCalculatorActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poke_indiv_calculator, menu);
		return true;
	}
	
	public void createIndivCalc(View v){
		Intent intent = new Intent(MenuActivity.this,IndividualCalculatorActivity.class);
		startActivity(intent);
	}
	
	public void createGuide(View v){
		//TODO:図鑑画面への遷移
	}
	
	public void createDamageCalc(View v){
		//TODO:ダメージ計算機への遷移
	}
	
	public void createStatusCalc(View v){
		//TODO:ステータス計算機への遷移
	}
	
	public void callSettings(View v){
		//TODO:設定画面の呼び出し
	}
}
