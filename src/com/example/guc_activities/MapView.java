package com.example.guc_activities;

//import com.example.allinone.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

//import com.example.hartajone.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapView extends FragmentActivity 
	
/*	implements 
	OnMyLocationButtonClickListener,
	ConnectionCallbacks,
	OnConnectionFailedListener, 
	com.google.android.gms.location.LocationListener{

private GoogleMap mMap;
private LocationClient mLocationClient;


@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.map_view, menu);
	return true;
}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_view);
		alertbox("MAP","Create");
		setUpMapIfNeeded();
	}



	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the map.
		if (mMap == null) {
			// Try to obtain the map from the SupportMapFragment.
			mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1)).getMap();
			alertbox("MAP","Map null?");
			// Check if we were successful in obtaining the map.
			if (mMap != null) {
				mMap.setMyLocationEnabled(true);
				mMap.setOnMyLocationButtonClickListener(this);
				alertbox("MAP","Map not null?");
				}
			}
	}

	private static final LocationRequest REQUEST = LocationRequest.create()
			.setInterval(5000)         
			.setFastestInterval(16)   
			.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

	private void setUpLocationClientIfNeeded() {
		if (mLocationClient == null) { mLocationClient = new LocationClient(getApplicationContext(),
				this,  // ConnectionCallbacks
				this); // OnConnectionFailedListener
		alertbox("MAP","SetupLocationClientifneeded");
}
}

	@Override
	public void onLocationChanged(Location loc) {
		LatLng latLng = new LatLng(loc.getLatitude(),loc.getLongitude());
		CameraUpdate camU = CameraUpdateFactory.newLatLngZoom(latLng,15);
		mMap.animateCamera(camU);
		alertbox("MAP","On location changed");
}

	public boolean onMyLocationButtonClick() {
		
		alertbox("MAP","onMyLocationButtonClick");
		return false;
}


@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
	alertbox("MAP","ConnectionFailed");
}
	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		alertbox("MAP","Disconected");

}
	@Override
	public void onConnected(Bundle connectionHint) {
		mLocationClient.requestLocationUpdates(REQUEST,this);
		alertbox("MAP","onConnected");
}

	@Override

	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
		setUpLocationClientIfNeeded();
		mLocationClient.connect();
		alertbox("MAP","onResume");
}
	@Override
	public void onPause() {
		super.onPause();
		if (mLocationClient != null) {
			mLocationClient.disconnect();
			alertbox("MAP","MyLocation not null--onPause");
}
}
	
	protected void alertbox(String title, String mymessage)
	   {
	   new AlertDialog.Builder(this)
	      .setMessage(mymessage)
	      .setTitle(title)
	      .setCancelable(true)
	      .setNeutralButton(android.R.string.cancel,
	         new DialogInterface.OnClickListener() {
	         public void onClick(DialogInterface dialog, int whichButton){}
	         })
	      .show();
	   }

}
*/

implements OnMyLocationButtonClickListener,
ConnectionCallbacks,
OnConnectionFailedListener, com.google.android.gms.location.LocationListener{

private GoogleMap mMap;
private LocationClient mLocationClient;

private static final LocationRequest REQUEST = LocationRequest.create()
 .setInterval(5000)         
 .setFastestInterval(16)   
 .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_map_view);
setUpMapIfNeeded();

}
@Override

protected void onResume() {
super.onResume();
setUpMapIfNeeded();
setUpLocationClientIfNeeded();
mLocationClient.connect();
}
@Override
public void onPause() {
 super.onPause();
 if (mLocationClient != null) {
     mLocationClient.disconnect();
 }
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.map_view, menu);
return true;
}

private void setUpMapIfNeeded() {
 // Do a null check to confirm that we have not already instantiated the map.
 if (mMap == null) {
     // Try to obtain the map from the SupportMapFragment.
     mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1)).getMap();
     // Check if we were successful in obtaining the map.
     if (mMap != null) {
         mMap.setMyLocationEnabled(true);
         mMap.setOnMyLocationButtonClickListener(this);
     }
 }
}
public boolean onMyLocationButtonClick() {
 return false;
}
@Override
public void onLocationChanged(Location loc) {
	LatLng latLng = new LatLng(loc.getLatitude(),loc.getLongitude());
	CameraUpdate camU = CameraUpdateFactory.newLatLngZoom(latLng,15);
	mMap.animateCamera(camU);
}


@Override
public void onConnectionFailed(ConnectionResult result) {
	// TODO Auto-generated method stub
	
}
@Override
public void onDisconnected() {
	// TODO Auto-generated method stub
	
}
@Override
public void onConnected(Bundle connectionHint) {
	mLocationClient.requestLocationUpdates(REQUEST,this);  
}
private void setUpLocationClientIfNeeded() {
 if (mLocationClient == null) { mLocationClient = new LocationClient(getApplicationContext(),
             this,  // ConnectionCallbacks
             this); // OnConnectionFailedListener
 }
}


}

		



