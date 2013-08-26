package com.javoe.firstrelease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class RestaurantActivity extends Activity implements OnClickListener {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.restaurant);
		
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		//Set OnClickListeners for the 10 Foods
		((LinearLayout)findViewById(R.id.food1)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food2)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food3)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food4)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food5)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food6)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food7)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food8)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food9)).setOnClickListener(this);
		((LinearLayout)findViewById(R.id.food10)).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.food1:
			startActivity(new Intent("android.intent.action.Food"));
			break;
		case R.id.food2:
			break;
		case R.id.food3:
			break;
		case R.id.food4:
			break;
		case R.id.food5:
			break;
		case R.id.food6:
			break;
		case R.id.food7:
			break;
		case R.id.food8:
			break;
		case R.id.food9:
			break;
		case R.id.food10:
			break;
		default:
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.restaurant_activity_actionbar, menu);
		
		//Set Spinner options
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.filters, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner menuSpinner1 = (Spinner)(((MenuItem)(menu.findItem(R.id.menu_spinner1))).getActionView());
		menuSpinner1.setAdapter(adapter);
		
		//Set ToggleButton text
		ToggleButton menuToggle1 =  (ToggleButton)(((MenuItem)(menu.findItem(R.id.menu_toggle1))).getActionView());
		menuToggle1.setText("▼");
		menuToggle1.setTextOn("▲");
		menuToggle1.setTextOff("▼");
		menuToggle1.setTextSize(30);
				
		return super.onCreateOptionsMenu(menu);
	}
	
}
