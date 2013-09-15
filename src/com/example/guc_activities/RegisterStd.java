package com.example.guc_activities;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class RegisterStd extends Activity {
//SQLDatabase variables
static final String dbName="Database1";
static final String stdTable="Students";
static final String stdID="StudentID";
static final String stdName="StudentName";
static final String stdAge="Age";
static final String stdNat="Nat";
static final String favGame="Game";
static final String Contact="Contact";
//Saving the instance state
private SharedPreferences pref;
private String prefName = "MyPref";
String name;
String age;
String nat;
String game;
String contact;
private final static String NAME="Name";
private final static String AGE="Age";
private final static String NAT="Nationality";
private final static String GAME="Game";
private final static String CONTACT="Contact";

	public SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_std);
	
		  
		        Button button = (Button) findViewById(R.id.btnGUC);
		        button.setOnClickListener(new OnClickListener() {
		        public void onClick(View v) {
		        Delete();
		        }}); 
		        
	 	/*name=savedInstanceState.getString(NAME);
		age=savedInstanceState.getString(AGE);
		nat=savedInstanceState.getString(NAT);
		game=savedInstanceState.getString(GAME);
		contact=savedInstanceState.getString(CONTACT);
		Set();*/

        String sql="Create Table if not exists "+stdTable + "("+stdID+" integer primary key ,"+ stdName +
        		" varchar, "+stdAge+" Integer,"+stdNat+" varchar ,"+favGame+" varchar)";
       // String del="DELETE FROM "+stdTable+" WHERE "+stdName+" like '';";
        try{
        db=openOrCreateDatabase(dbName,MODE_PRIVATE, null);
        db.execSQL(sql);
        //db.execSQL(del);
   
        }
        catch(Exception ex)
        {
        	alertbox("Error",ex.getMessage());
     	   //MessageBox(ex.getMessage());
        }
	}
	 
  
    

	@Override
	   public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register_std, menu);
		return true;
	}
	   public void MessageBox(String s)
	    {
	    	Toast.makeText(this, s,Toast.LENGTH_SHORT).show();
	    }
	   public void Send(View v)
	   {

		   EditText e1=(EditText)findViewById(R.id.StdID);
		   EditText e2=(EditText)findViewById(R.id.etname);
		   EditText e3=(EditText)findViewById(R.id.etage);
		   EditText e4=(EditText)findViewById(R.id.etnat);
		   EditText e5=(EditText)findViewById(R.id.etfavgame);
		   EditText e6=(EditText)findViewById(R.id.etconatact);
		    try{
		    	
		    String ID=e1.getText().toString();
		    Integer intID=Integer.parseInt(ID);
		    name=e2.getText().toString();
		    age=e3.getText().toString();
		    nat=e4.getText().toString();
		    game=e5.getText().toString();
		    contact=e6.getText().toString();
		    
		    if(intID==null |name==""|age==""|nat==""|game==""|contact=="")
		    {
		    	alertbox("Error","Please fill in all the fields!");
		    	return;
		    }
		    else {
		    
		
	    	try 
	    	{
	    		String query="Insert into "+ stdTable+" ("+stdID+", "+ stdName +
		        		", "+stdAge+" ,"+stdNat+" ,"+favGame+" ,"+ Contact +") values ('"+intID+"','"+name+"','"+age+"','"+game+"','"+nat+"','"+contact+"');";

	    		String query1="Insert into "+ stdTable+" ("+stdID+", "+ stdName +
		        		", "+stdAge+" ,"+stdNat+" ,"+favGame+") values ('"+intID+"','"+name+"','"+age+"','"+game+"','"+nat+"');";

	    	
	    	   	db.execSQL(query1);
	    	   	e1.setText("");
	    	   	e2.setText("");
	    	   	e3.setText("");
	    	   	e4.setText("");
	    	   	e5.setText("");
	    	   	e6.setText("");
	    	alertbox("Information","Thank you "+name+"!"+"\nYour information has been succesfully submited ");
	    	//MessageBox("Thank you "+name+"!"+"\nYour information has been succesfully submited ");

	    	}
	    	catch (Exception ex)
	    	{
	    		 MessageBox(ex.getMessage());
	    	}
		    }
	}
		    catch(Exception ex)
			   {
				   MessageBox(ex.getMessage());
			   }
		    
	   }
	   
		public void activity2(View v)
		{
			MessageBox("View all the international students!!");
			Intent I =new Intent(RegisterStd.this,ViewStd.class);
			RegisterStd.this.startActivity(I);
			
		}
		protected void alertbox(String title, String mymessage)
		   {
		   new AlertDialog.Builder(this)
		      .setMessage(mymessage)
		      .setTitle(title)
		      .setCancelable(true)
		      .setNeutralButton(android.R.string.ok,
		         new DialogInterface.OnClickListener() {
		         public void onClick(DialogInterface dialog, int whichButton){}
		         })
		      .show();
		   }
		
		/*
		protected void onSaveInstanceState(Bundle saveInstanceState) {
		     super.onSaveInstanceState(saveInstanceState);
		     Get();
			 pref =getSharedPreferences(prefName,MODE_PRIVATE);
		 	 SharedPreferences.Editor editor=pref.edit();
		 	 editor.putString(NAME, name);
		 	 editor.putString(AGE, age);
		 	 editor.putString(NAT, nat);
		 	 editor.putString(GAME, game);
		 	 editor.putString(CONTACT, contact);
		 	 
		 	 editor.commit();

		    }*/
		@Override
		 protected void onResume()
		  {
		  	super.onResume();
		  
		
		  	pref =getSharedPreferences(prefName,MODE_PRIVATE);
			name=pref.getString(NAME, "");
			age=pref.getString(AGE, "");
			nat=pref.getString(NAT, "");
			game=pref.getString(GAME, "");
			contact=pref.getString(CONTACT, "");
			Set();
			
		      

			
		  }
		/*
		 protected  void OnRestoreInstanceState(Bundle savedState)  {
		 super.onRestoreInstanceState(savedState); 
		
		 	name=savedState.getString(NAME);
			age=savedState.getString(AGE);
			nat=savedState.getString(NAT);
			game=savedState.getString(GAME);
			contact=savedState.getString(CONTACT);
			Set();
		  
		 }*/
		/* 
		 @Override
		 protected void onDestroy()
		  {
			 alertbox("hej","Distroy");
			 Get();
			 pref =getSharedPreferences(prefName,MODE_PRIVATE);
		 	 SharedPreferences.Editor editor=pref.edit();
		 	 editor.putString(NAME, name);
		 	 editor.putString(AGE, age);
		 	 editor.putString(NAT, nat);
		 	 editor.putString(GAME, game);
		 	 editor.putString(CONTACT, contact);
		 	 
		 	 editor.commit();
		  }*/
		  
		 @Override
		 protected void onPause()

		    {
		    	super.onPause();

		    	 Get();
				 pref =getSharedPreferences(prefName,MODE_PRIVATE);
			 	 SharedPreferences.Editor editor=pref.edit();
			 	 editor.putString(NAME, name);
			 	 editor.putString(AGE, age);
			 	 editor.putString(NAT, nat);
			 	 editor.putString(GAME, game);
			 	 editor.putString(CONTACT, contact);
			 	 
			 	 editor.commit();
		    }
		 private void Get()
		 {
			   //EditText e1=(EditText)findViewById(R.id.StdID);
			   EditText e2=(EditText)findViewById(R.id.etname);
			   EditText e3=(EditText)findViewById(R.id.etage);
			   EditText e4=(EditText)findViewById(R.id.etnat);
			   EditText e5=(EditText)findViewById(R.id.etfavgame);
			   EditText e6=(EditText)findViewById(R.id.etconatact);
			   //String ID=e1.getText().toString();
			   //Integer intID=Integer.parseInt(ID);
			   name=e2.getText().toString();
			   age=e3.getText().toString();
			   nat=e4.getText().toString();
			   game=e5.getText().toString();
			   contact=e6.getText().toString();
		 }
		 
		 private void Set()
		 {
		           EditText e1=(EditText)findViewById(R.id.StdID);
				   EditText e2=(EditText)findViewById(R.id.etname);
				   EditText e3=(EditText)findViewById(R.id.etage);
				   EditText e4=(EditText)findViewById(R.id.etnat);
				   EditText e5=(EditText)findViewById(R.id.etfavgame);
				   EditText e6=(EditText)findViewById(R.id.etconatact);
				   e2.setText(name);
				   e3.setText(age);
				   e4.setText(nat);
				   e5.setText(game);
				   e6.setText(contact);
			 
		 }
		 
		 public void Delete()
		 {
			   EditText e1=(EditText)findViewById(R.id.StdID);
			   EditText e2=(EditText)findViewById(R.id.etname);
			   EditText e3=(EditText)findViewById(R.id.etage);
			   EditText e4=(EditText)findViewById(R.id.etnat);
			   EditText e5=(EditText)findViewById(R.id.etfavgame);
			   EditText e6=(EditText)findViewById(R.id.etconatact);
			 	e1.setText("");
	    	   	e2.setText("");
	    	   	e3.setText("");
	    	   	e4.setText("");
	    	   	e5.setText("");
	    	   	e6.setText("");
		 }

		
}
