package com.example.proyecto;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Adriana on 21/06/2014.
 */
public class JSONManager {
    public static JSONObject getJSONfromURL(String url){
        InputStream is = null;
        String result = "";
        JSONObject json = null;
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.i("eoooooooooooooooooooooooooooooo", "URL = "+url+" - Resultado: "+is.toString());
        }catch(Exception e){
            Log.i("eoooooooooooooooooooooooooooooo", "Error al llamar al servidor web, URL= " + url);
            e.printStackTrace();
        }
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n"); //cambiar estoo pa que coja lo que esta entre llaves
            }
            is.close();
            result=sb.toString();
        } catch(Exception e){

        }

        try{
            Log.i("eoooooooooooooooooooooooooooooo", "Resultado: "+result);
            json = new JSONObject(result);
            Log.i("eooooooooooooooooooo", "Objeto JSON: " + result);
        }catch(JSONException e){
            Log.i("eeeeeeooooooooooooooooooooooo", "Error al crear el objeto JSON");
        }

        return json;
    }

    public static JSONArray getJSONArrayfromURL(String url){
        InputStream is = null;
        String result = "";
        JSONArray json = null;
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            Log.i("eoooooooooooooooooooooooooooooo", "URL = "+url+" - Resultado: "+ is.toString());
        }catch(Exception e){
            Log.i("eoooooooooooooooooooooooooooooo", "Error al llamar al servidor web, URL= " + url);
            e.printStackTrace();
        }

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n"); //cambiar estoo pa que coja lo que esta entre llaves
            }
            is.close();
            result=sb.toString();
        } catch(Exception e){ }

        try{
            Log.i("eoooooooooooooooooooooooooooooo", "Resultado: "+result);
            json = new JSONArray(result);
            Log.i("eooooooooooooooooooo", "Objeto JSONArray: " + result);
        }catch(JSONException e){
            Log.i("eeeeeeooooooooooooooooooooooo", "Error al crear el objeto JSON");
        }

        return json;
    }
}
