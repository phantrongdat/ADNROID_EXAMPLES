package com.example.alone.demooptionmenu;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Spinner spMenu;
	TextView txtHello;
	String[] fonts = {"Fonts","Colors"};
	Typeface typeFace; 
	int color;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spMenu = (Spinner)findViewById(R.id.spMenu);
		txtHello = (TextView)findViewById(R.id.txtHello);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
		(this, android.R.layout.simple_spinner_item, fonts);
		
		spMenu.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate
		(R.menu.option_menu_font, menu);
		return true;
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		int item = spMenu.getSelectedItemPosition();
		switch (item) {
		case 0:
			menu.clear();
			getMenuInflater().inflate(R.menu.option_menu_font, menu);
			break;
		case 1:
			menu.clear();
			getMenuInflater().inflate(R.menu.option_menu_color, menu);
			break;
		}
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.arial:
			typeFace = Typeface.createFromAsset(getAssets(), "arial.ttf");
			txtHello.setTypeface(typeFace);
			break;
		case R.id.times:
			typeFace = Typeface.createFromAsset(getAssets(), "times.ttf");
			txtHello.setTypeface(typeFace);
			break;
		case R.id.century:
			typeFace = Typeface.createFromAsset(getAssets(), "century.ttf");
			txtHello.setTypeface(typeFace);
			break;
		case R.id.comic:
			typeFace = Typeface.createFromAsset(getAssets(), "comic.ttf");
			txtHello.setTypeface(typeFace);
			break;
		case R.id.roboto:
			typeFace = Typeface.createFromAsset(getAssets(), "roboto.ttf");
			txtHello.setTypeface(typeFace);
			break;
		case R.id.blue:
			color = getResources().getColor(R.color.blue);
			txtHello.setTextColor(color);
			break;
		case R.id.green:
			color = getResources().getColor(R.color.green);
			txtHello.setTextColor(color);
			break;
		case R.id.red:
			color = getResources().getColor(R.color.red);
			txtHello.setTextColor(color);
			break;
		case R.id.purple:
			color = getResources().getColor(R.color.purple);
			txtHello.setTextColor(color);
			break;
		case R.id.yellow:
			color = getResources().getColor(R.color.yellow);
			txtHello.setTextColor(color);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
