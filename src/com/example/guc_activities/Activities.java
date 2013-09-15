package com.example.guc_activities;

//import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
//import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;


public class Activities extends Activity {
	
	public static String DAY="Day";
	private SharedPreferences pref;
	private String prefName = "MyPref";
	String day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activities);
		try{
			String[] items = new String[] {"Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday"};
			Spinner sp=(Spinner)findViewById(R.id.spinner1);
		sp.setAdapter(new ArrayAdapter<String>(this,
               android.R.layout.simple_spinner_item, items));
		}
		catch(Exception ex)
		{
			MessageBox(ex.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activities, menu);
		return true;
	}
	
	 public void MessageBox(String s)
	    {
	    	Toast.makeText(this, s,Toast.LENGTH_SHORT).show();
	    }
	 public void hello(View v)
	 {
		 Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);
		 String Text = mySpinner.getSelectedItem().toString();
		 DAY=Text;
		 

		 
		 Intent I=new Intent (Activities.this,RegActivity.class);
		 I.putExtra("DAY", DAY);
		 Activities.this.startActivity(I);
	 }
	 
	 public void viewHang(View v)
	 {
		 Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);
		 String Text = mySpinner.getSelectedItem().toString();
		 DAY=Text;
		 

		 
		 Intent I=new Intent (Activities.this,ViewHangout.class);
		 I.putExtra("DAY", DAY);
		 Activities.this.startActivity(I);
		 
	 }

	 @Override
	 protected void onPause()
	 {
		 super.onPause();
		 pref=getSharedPreferences(prefName,MODE_PRIVATE);
		 Spinner s=(Spinner)findViewById(R.id.spinner1);
		 day=s.getSelectedItem().toString();
		 SharedPreferences.Editor editor=pref.edit();
		 editor.putString(DAY, day);
		 editor.commit();
	 }
	 
	 @Override 
	 protected void onResume()
	 {
		 super.onResume();
		 pref=getSharedPreferences(prefName,MODE_PRIVATE);
		 day=pref.getString(DAY, "Monday");
		 Integer i;
		 if(day=="Monday")
			 i=0;
		 else if (day=="Tuesday")
			 i=1;
		 else if (day=="Wednesday")
			 i=2;
		 else if (day=="Thursday")
			 i=3;
		 else if (day=="Friday")
			 i=4;
		 else if (day=="Saturday")
			 i=5;
		 else  
			 i=6;
		 
		 Spinner s=(Spinner)findViewById(R.id.spinner1);
		 s.setSelection(i);
		 
		 
	 }
	 
	 protected  void OnRestoreInstanceState(Bundle savedState)  {
		 super.onRestoreInstanceState(savedState); 
		
		 	day=savedState.getString(DAY);
		 	Integer i;
			 if(day=="Monday")
				 i=0;
			 else if (day=="Tuesday")
				 i=1;
			 else if (day=="Wednesday")
				 i=2;
			 else if (day=="Thursday")
				 i=3;
			 else if (day=="Friday")
				 i=4;
			 else if (day=="Saturday")
				 i=5;
			 else  
				 i=6;
			 
			 Spinner s=(Spinner)findViewById(R.id.spinner1);
			 s.setSelection(i);
		
			
	 }
	 protected void onSaveInstanceState(Bundle saveInstanceState) {
	     super.onSaveInstanceState(saveInstanceState);
	     
		 pref =getSharedPreferences(prefName,MODE_PRIVATE);
		 Spinner s=(Spinner)findViewById(R.id.spinner1);
		 day=s.getSelectedItem().toString();
	 	 SharedPreferences.Editor editor=pref.edit();
	 	 editor.putString(DAY, day);
	 	
	 	 
	 	 editor.commit();

	    }
}
