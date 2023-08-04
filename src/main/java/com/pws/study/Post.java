package com.pws.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {
	public JSONObject jsonpost(String url,JSONObject json)
	{
		HttpURLConnection connection = null;
		try {
			String apiURL = "http://127.0.0.1:5000"+url; 
			URL link = new URL(apiURL);
			connection = (HttpURLConnection)link.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setDoOutput(true);
			OutputStreamWriter wr = null;
			wr = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
			wr.write(json.toString());
			wr.flush();
			wr.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String returnMsg = reader.readLine();
	        JSONObject jsonObject = new JSONObject(returnMsg);

			return jsonObject;
		}catch(IOException e)
		{
			e.printStackTrace();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		 
		JSONObject result = new JSONObject();
		try {
			result.put("check","false");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
