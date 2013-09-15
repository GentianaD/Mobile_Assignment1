package com.example.guc_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.plus.model.people.Person.Image;

public class Activity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
		
		Button b1=(Button)findViewById(R.id.btnGUC);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity1, menu);
		return true;
	}
	public void RegStudents(View v)
	{
		MessageBox("Welcome to the Register Students page!!");
		Intent I =new Intent(Activity1.this,RegisterStd.class);
		Activity1.this.startActivity(I);
		
	}
	
	
	public void Hangouts(View v)
	{
		MessageBox("Welcome to the Hangout page!");
		Intent I =new Intent(Activity1.this,Activities.class);
		Activity1.this.startActivity(I);
		
	}
	
	public void Download(View v)
	{
		MessageBox("Welcome to the HIG!!!!!");
		Intent I =new Intent(Activity1.this,WebImage.class);
		Activity1.this.startActivity(I);
		
	}
	public void MAP(View v)
	{
		MessageBox("The MAP!!!!!");
		Intent I =new Intent(Activity1.this,MapView.class);
		Activity1.this.startActivity(I);
		
	}
	
	   public void MessageBox(String s)
	    {
	    	Toast.makeText(this, s,Toast.LENGTH_SHORT).show();
	    }

}
