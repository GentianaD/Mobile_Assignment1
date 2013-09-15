package com.example.guc_activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Simple activity demonstrating the way a file can be downloaded 
 * via HTTP from a web server. It showcases three patterns:
 * - downloading an image
 * - downloading a pure HTML file
 * - downloading RSS feed
 * 
 * 
 * This is part of Mobile Programming course.
 * 
 * Copyright (C) 2013 HiG.
 */
public class WebImage extends Activity {

	
	final static String IMAGE_URL = "http://gtl-gear.appspot.com/static/img/gtl-logo_h57.png";
	final static String TEXT_URL = "http://google.no";
	final static String RSSFEED_URL = "http://rss.slashdot.org/Slashdot/slashdotGames";
	final static String IMAGE_URL1="http://www.ikt-innlandet.no/wp-content/uploads/locations-pics/location-4.jpg";    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_image);
        
        try {
			new DownloadImageTask().execute(new URL(IMAGE_URL1));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        
        
       /* 
        try {
			new DownloadTextTask().execute(new URL(TEXT_URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        
        try {
			new DownloadRSSTask().execute(new URL(RSSFEED_URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
       
    }
    
    
    
    
    
    /**
     * Task, responsible for downloading a string from a given URL.
     * This task will execute the download asynchronously, and fill up the 
     * UI field when ready. 
     * 
     * The class is parameterized with the way we want to handle progress,
     * and what we want to return as the result of executing the action. 
     * In our case here, we do not care about progress, and the result 
     * is a String.
     * 
     * Remember, asynchronous task cannot manipulate 
     * UI elements - these need to be updated from within the main thread, 
     * and this is why we put the code into onPostExecute.
     * 
     */
   
    
    
    
    
    
    
    /**
     * Task, responsible for downloading an image from a given URL.
     * This task will execute the download asynchronously, and fill up the 
     * UI field when ready.
     * We are not interested in counting progress. We are returning 
     * a Bitmap from the task.
     */
    private class DownloadImageTask extends AsyncTask<URL, Void, Bitmap> {
    	@Override
    	protected Bitmap doInBackground(URL... urls) {
    		assert urls.length == 1; // sanity check
            return downloadImage(urls[0]);
        }
    	@Override
    	protected void onPostExecute(Bitmap bitmap) {
            //Then display the image to a view
            final ImageView img = (ImageView) findViewById(R.id.imageView1);
            img.setImageBitmap(bitmap);
    	}
    }
    
    /**
     * This function downloads the image at the URL
     * location passed and then returns the bitmap
     * @param  URL     an absolute URL giving the base location and name of the image
     * @return bitmap  the image at the specified URL
     *
     */
    private Bitmap downloadImage(final URL url) {
        Bitmap bitmap = null;
        InputStream in = null;        
        try {
            in = openHttpConnection(url);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;                
    }

    
    

   
    /**
     * Task, responsible for downloading a RSS feed a given URL.
     * This task will execute the download asynchronously, and fill up the 
     * UI field when ready.
     */
   
    /**
     * Handles some of the complexity of opening up a HTTP connection
     * @param  URL   a String containing the absolute URL giving the base location and name of the content
     * @return in    an inputStream which will be the stream of text from the server
     */    
    private InputStream openHttpConnection(final URL url) throws IOException {
        InputStream in = null;
        int response = -1;
        final URLConnection conn = url.openConnection();
                 
        if (!(conn instanceof HttpURLConnection)) {                     
            throw new IOException("Not an HTTP connection");
        }
        
        try {
            final HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect(); 

            response = httpConn.getResponseCode();                 
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();                                 
            }                     
        } catch (Exception ex) {
        	ex.printStackTrace();            
        }
        return in;     
    }
    
}

