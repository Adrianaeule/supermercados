package com.example.proyecto;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class ConsultaIsla extends AsyncTask<String,Void,JSONObject> {
	@Override
    protected JSONObject doInBackground(String... params) { //le pasamos los parametros que necesitemos
    	JSONObject Isla_Seleccionada;
    	String isla = params[0];
        Log.i("eoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", "Isla elegida: " + isla);
        isla = isla.replace(" ", "_");
        String URL = "http://192.168.1.42:54321/API/Islas?isla=" + isla;
        Isla_Seleccionada = JSONManager.getJSONfromURL(URL);
        return Isla_Seleccionada;
    }

	@Override
    protected void onPostExecute(JSONObject result) {
        //metodo que mas tarde se sobreescribira
	}

}
