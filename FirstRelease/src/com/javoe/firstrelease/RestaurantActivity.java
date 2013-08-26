package com.javoe.firstrelease;

import java.util.ArrayList;

import com.javoe.firstrelease.MainActivity.Restaurant;
import com.javoe.firstrelease.MainActivity.RestaurantView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class RestaurantActivity extends Activity{
	//Food Class
	class Food{
		int imgId;
		String text;
	}
			
	// FoodView Class
	class FoodView{
		private LinearLayout linLay;
		private ImageView imgView;
		private TextView txtView;
		
		public FoodView(Context c, int imageId, String text){
			linLay = new LinearLayout(c);
			linLay.setOrientation(LinearLayout.HORIZONTAL);
			linLay.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			
			imgView = new ImageView(c);
			imgView.setImageResource(imageId);
			txtView = new TextView(c);
			txtView.setText(text);
		}
		
		// Sets the OnClickListener for the object
		public void setOnClickListener(OnClickListener l){
			linLay.setOnClickListener(l);
		}
		
		// Returns the object's LinearLayout
		public LinearLayout getLinLay(){
			return linLay;
		}
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.restaurant);
		
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	

		ArrayList<Food> foods = getFoods();
		for(int i = 0; i < foods.size(); i++){
			Food f = foods.get(i);
			FoodView fView = createView(f);
			fView.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					openFood(v);
				}
			});
			addView(fView);
		}
		
	}
	
	private void addView(FoodView fView) {
		((ScrollView)findViewById(R.id.scrMain)).addView(fView.getLinLay());
	}

	public void openFood(View v){
		startActivity(new Intent("android.intent.action.Food"));
	}
	
	public FoodView createView(Food f){
		FoodView fView = new FoodView(this, f.imgId, f.text);
		return fView;
	}
	
	public ArrayList<Food> getFoods(){
		ArrayList<Food> foods = new ArrayList<Food>();
		
		// ... Get Restaurants from database ...
		
		return foods;
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
