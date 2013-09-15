package com.example.guc_activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class ViewStd extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_std);
		Read();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_std, menu);
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
		String query="Select * from Students";
		try
		{
			
			db=openOrCreateDatabase("Database1",MODE_PRIVATE,null);
			DataGrid=(GridView)findViewById(R.id.grid1);
			List<String> li= new ArrayList<String>();
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,li);
			dataAdapter.setDropDownViewResource(R.layout.activity_view_std);
		    Cursor cr=db.rawQuery(query, null);

			 if(cr!=null)
				{
					if(cr.moveToFirst())
					{
						do
						{
						String _name=cr.getString(1);
						String _age=cr.getString(2);
						String _nat=cr.getString(3);
						String _game=cr.getString(4);
						li.add(_name);
						li.add(_age);
						li.add(_nat);
						li.add(_game);
					
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
