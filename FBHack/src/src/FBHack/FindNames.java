/**
 * 
 */
package src.FBHack;

import android.graphics.Bitmap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Jared
 */
public class FindNames {

	String getName(Bitmap picture){

		Log.i("Jared", "Starting Name Search");
		
		String response = connect("http://api.face.com/faces/recognize.json?api_key=4b4b4c6d54c37&api_secret=&urls=http://i56.tinypic.com/axl7wj.jpg&uids=1148280035,1451989020,505129708&namespace=facebook.com&detector=Normal&attributes=all&user_auth=fb_user:1148280035,fb_session:4dfc139bfc184480241b3fc1.1-1148280035,fb_oauth_token:244103159565%7C4dfc139bfc184480241b3fc1.1-1148280035%7CfZr0T7bifEncT5FYGuN4JLSQ1n0&");


		Log.i("Jared", response);
		
		Log.i("Jared", "Found Name!");
				

		return response;
	}



	private static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the BufferedReader.readLine()
		 * method. We iterate until the BufferedReader return null which means
		 * there's no more data to read. Each line will appended to a StringBuilder
		 * and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/* This is a test function which will connects to a given
	 * rest service and returns it's response
	 */
	public String connect(String url)
	{

		HttpClient httpclient = new DefaultHttpClient();

		// Prepare a request object
		HttpGet httpget = new HttpGet(url); 

		// Execute the request
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			// Examine the response status
			Log.i("Praeda",response.getStatusLine().toString());

			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			// If the response does not enclose an entity, there is no need
			// to worry about connection release

			if (entity != null) {

				// A Simple JSON Response Read
				InputStream instream = entity.getContent();
				String result= convertStreamToString(instream);
				
/*
				// A Simple JSONObject Creation
				JSONObject json=new JSONObject(result);
				Log.i("Praeda","<jsonobject>\n"+json.toString()+"\n</jsonobject>");

				// A Simple JSONObject Parsing
				JSONArray nameArray=json.names();
				JSONArray valArray=json.toJSONArray(nameArray);
				for(int i=0;i<valArray.length();i++)
				{
					Log.i("Praeda","<jsonname"+i+">\n"+nameArray.getString(i)+"\n</jsonname"+i+">\n"
							+"<jsonvalue"+i+">\n"+valArray.getString(i)+"\n</jsonvalue"+i+">");
				}

				// A Simple JSONObject Value Pushing
				json.put("sample key", "sample value");
				Log.i("Praeda","<jsonobject>\n"+json.toString()+"\n</jsonobject>");
*/
				// Closing the input stream will trigger connection release
				instream.close();
				return result;
			}


		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//} catch (JSONException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		
		return "Failed to access JSON Face API, see stack trace";
	}

}

