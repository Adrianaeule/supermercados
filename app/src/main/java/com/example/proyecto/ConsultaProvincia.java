package com.example.proyecto;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URLEncoder;

public class ConsultaProvincia extends AsyncTask<String,Void,JSONObject> {

	@Override
    protected JSONObject doInBackground(String... params) { //le pasamos los parametros que necesitemos
    	JSONObject Provincia_Seleccionada;

    	String  provincia = params[0];
        provincia = provincia.replace(" ", "_");
        Log.i("eoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", "Provincia elegida: " + provincia);

        String URL = "http://192.168.1.42:54321/API/Provincias?provincia=" + provincia;
        Provincia_Seleccionada = JSONManager.getJSONfromURL(URL);
        return Provincia_Seleccionada;
    }
		
	@Override
    protected void onPostExecute(JSONObject result) {
        //metodo que mas tarde se sobreescribira
	}
}
