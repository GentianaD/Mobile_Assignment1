package com.example.guc_activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends Activity {
	
	static final String dbName="Database2";
	static final String outTable="Hangouts";
	static final String time="Time";
	static final String day="Day";
	static final String discription="Discription";
	static final String where="_Where";
	static final String place="Place";
	static final String ID="HangoutID";
	String Day;
	
	private SharedPreferences pref;
	static final String prefName="Preferences";
	static final String TIME="Time";
	static final String WHERE="Where";
	static final String DISCRIPTION="discription";
	String strTime;
	String strWhere;
	String strDay;
	String strDiscr;
	public SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		Button button=(Button)findViewById(R.id.btnCreateHangouts);
		  button.setOnClickListener(new OnClickListener() {
		        public void onClick(View v) {
		        	EditText _ettime=(EditText)findViewById(R.id.etage);
					   EditText _etwhere=(EditText)findViewById(R.id.etwhere);
					   EditText _etdiscr=(EditText)findViewById(R.id.etname);
					   EditText _etday=(EditText)findViewById(R.id.etfavgame);
					   _ettime.setText("");
					   _etwhere.setText("");
					   _etdiscr.setText("");
					  // _etday.setText("");
		        }}); 
		
		Intent I=getIntent();
		Day=I.getStringExtra("DAY");
		MessageBox(Day);
		EditText _etday=(EditText)findViewById(R.id.etfavgame);
		_etday.setText(Day);
		String query="Create table if not exists "+outTable +"("+time+" varchar,"+day+" varchar,"+discription+" varchar ,"+place+" varchar) ";
        try{
        db=openOrCreateDatabase(dbName,MODE_PRIVATE, null);
        db.execSQL(query);
        
        }
        catch(Exception ex)
        {
     	   MessageBox(ex.getMessage());
        }
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg, menu);
		return true;
	}
	
	 public void MessageBox(String s)
	    {
	    	Toast.makeText(this, s,Toast.LENGTH_SHORT).show();
	    }
	 public void Send(View v)
	   {
		   try{
		   EditText _ettime=(EditText)findViewById(R.id.etage);
		   String strTime=_ettime.getText().toString();
		   EditText _etwhere=(EditText)findViewById(R.id.etwhere);
		   String strWhere=_etwhere.getText().toString();
		   String strDay=Day;
		   EditText _etdiscr=(EditText)findViewById(R.id.etname);
		   String strDiscr=_etdiscr.getText().toString();
		   EditText _etday=(EditText)findViewById(R.id.etfavgame);
		   
		   String query="Insert into "+ outTable+" ("+time+", "+ day +
	        		","+discription+","+place+") values ('"+strTime+"','"+strDay+"','"+strDiscr+"','"+strWhere+"');";
		   db.execSQL(query);
		   MessageBox("You have successfuly inserted a hangout !!");
		   _ettime.setText("");
		   _etwhere.setText("");
		   _etdiscr.setText("");
		   _etday.setText("");
		   }
		   catch(Exception e)
		   {
			   MessageBox(e.getMessage());
		   }
	   

}
		private void Get()
		{
			   EditText _ettime=(EditText)findViewById(R.id.etage);
			   EditText _etwhere=(EditText)findViewById(R.id.etwhere);
			   EditText _etdiscr=(EditText)findViewById(R.id.etname);
			   EditText _etday=(EditText)findViewById(R.id.etfavgame);
			   
			   strTime=_ettime.getText().toString();
			   strWhere=_etwhere.getText().toString();
			   strDay=Day;
			   strDiscr=_etdiscr.getText().toString();
		}
		
		private void Set()
		{

			   EditText _ettime=(EditText)findViewById(R.id.etage);
			   EditText _etwhere=(EditText)findViewById(R.id.etwhere);
			   EditText _etdiscr=(EditText)findViewById(R.id.etname);
			   EditText _etday=(EditText)findViewById(R.id.etfavgame);
			   
			   _ettime.setText(strTime);
			   _etwhere.setText(strWhere);
			   //String strDay=Day;
			   _etdiscr.setText(strDiscr);
		}

		/*protected void onSaveInstanceState(Bundle saveInstanceState) {
		     super.onSaveInstanceState(saveInstanceState);
		     Get();
			 pref =getSharedPreferences(prefName,MODE_PRIVATE);
		 	 SharedPreferences.Editor editor=pref.edit();
		 	 editor.putString(TIME, strTime);
		 	 editor.putString(WHERE, strWhere);
		 	 editor.putString(DISCRIPTION, strDiscr);
		 	 
		 	 editor.commit();

		    }*/


		@Override
		 protected void onResume()
		  {
		  	super.onResume();
		  
		
		  	pref =getSharedPreferences(prefName,MODE_PRIVATE);
			strTime=pref.getString(TIME, "");
			strWhere=pref.getString(WHERE, "");
			strDiscr=pref.getString(DISCRIPTION, "");
			Set();
			
		      

			
		  }
		 
		/*protected  void OnRestoreInstanceState(Bundle savedState)  {
			 super.onRestoreInstanceState(savedState); 
			
			 	strTime=savedState.getString(TIME);
			 	strWhere=savedState.getString(WHERE);
				strDiscr=savedState.getString(DISCRIPTION);
			
				Set();
			  
			 }*/

		@Override
		 protected void onPause()

		    {
		    	super.onPause();

		    	   Get();
					 pref =getSharedPreferences(prefName,MODE_PRIVATE);
				 	 SharedPreferences.Editor editor=pref.edit();
				 	 editor.putString(TIME, strTime);
				 	 editor.putString(WHERE, strWhere);
				 	 editor.putString(DISCRIPTION, strDiscr);
				 	 
				 	 editor.commit();
		    }
}

