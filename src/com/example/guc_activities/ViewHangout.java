package com.example.guc_activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class ViewHangout extends Activity {
	String Day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent in = getIntent();
        Day = in.getStringExtra("DAY");
        MessageBox(Day);

		setContentView(R.layout.activity_view_hangout);
		Read();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_hangout, menu);
		return true;
	}
	
	SQLiteDatabase db;
	GridView DataGrid;



	public void MessageBox(String s)
	    {
	    	Toast.makeText(this, s,Toast.LENGTH_SHORT).show();
	    }
	public void Read()
	{
		String query="Select * from  Hangouts where day like '"+Day+"';";
		try
		{
			
			db=openOrCreateDatabase("Database2",MODE_PRIVATE,null);
			DataGrid=(GridView)findViewById(R.id.grid1);
			List<String> li= new ArrayList<String>();
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,li);
			dataAdapter.setDropDownViewResource(R.layout.activity_view_hangout);
		    Cursor cr=db.rawQuery(query, null);
			// MessageBox("HELLOOOOO!!!!!!!!!");
			 if(cr!=null)
				{
					if(cr.moveToFirst())
					{
						do
						{
							//String ID = cr.getString(cr.getColumnIndex("_id"));
							//String Name = cr.getString(1);
							//String LastName = cr.getString(2);
						//String ID = cr.getString(cr.getColumnIndex("_id"));
						//String Name = cr.getString(cr.getColumnIndex("name"));
						//String LastName = cr.getString(cr.getColumnIndex("sname"));
						String time=cr.getString(0);
						//String day=cr.getString(1);
						String discription=cr.getString(2);
						String palce=cr.getString(3);
						//String _game=cr.getString(4);
						li.add(time);
						//li.add(day);
						li.add(discription);
						li.add(palce);
						//li.add(_game);
						//li.add(ID);
						//li.add(Name);
						//li.add(LastName);
						DataGrid.setAdapter(dataAdapter);
						}
						while(cr.moveToNext());
					}
				}
				else
				{
				  MessageBox("There is no Data!");
				}
				cr.close();
			}
			catch(Exception ex)
			{
				MessageBox(ex.getMessage());
				
			}
	}


}
