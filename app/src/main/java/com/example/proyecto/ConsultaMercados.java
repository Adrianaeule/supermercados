package com.example.proyecto;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class ConsultaMercados extends AsyncTask<Object,Void,JSONArray> {
	
    @Override
    protected JSONArray doInBackground(Object... params) { //le pasamos los parametros que necesitemos
	    JSONObject Mercado_Seleccionado;
        JSONArray Mercados_Seleccionados = null;
	    String lugar = (String) params[0];
        lugar = lugar.replace(" ", "_"); //MIRAR PORQUE NO ME RECONOCE EL ESPACIO!!
        String categoria = (String) params[1];
        categoria = categoria.replace(" ", "_");
	    Boolean provincia = (Boolean)params[2];
        String prov = provincia.toString(); //mirar si hace falta pasarlo en String o se lo puedo pasar en Boolean

        Log.i("eoooooooooooooooooooooooooooo", "Lugar: " + lugar+ ", Categoria: " +categoria+ " ¿Provincia? "+provincia);
        String URL = "http://192.168.1.42:54321/API/Mercados?lugar="+lugar+"&categoria="+categoria+"&provincia="+prov;
        Mercados_Seleccionados = JSONManager.getJSONArrayfromURL(URL);

        return Mercados_Seleccionados;
    }
	
    @Override
    protected void onPostExecute(JSONArray result) {
        //metodo que mas tarde se sobreescribira
    }
}
