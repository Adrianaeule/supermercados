package com.example.proyecto;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class ConsultaProductos extends AsyncTask<Object,Void,JSONArray> {
	
@Override
protected JSONArray doInBackground(Object... params) { //le pasamos los parametros que necesitemos
	JSONArray Mercado_Seleccionado;
	String lugar = (String) params[0];
    lugar = lugar.replace(" ", "_");
    String producto = (String) params[1];
    producto = producto.replace(" ", "_");
	String categoria = (String) params[2];
    categoria = categoria.replace(" ", "_");
    Boolean canario = (Boolean)params[3];
    Log.i("eoooooooooooooooooooooooooooo", "Lugar: " + lugar+ ", Categoria: " +categoria+ ", Producto=" +producto+" ¿Canario? "+canario);

    String URL = "http://192.168.1.42:54321/API/Productos?lugar="+lugar+"&producto="+producto+"&categoria="+categoria+"&canario="+canario;
    Mercado_Seleccionado = JSONManager.getJSONArrayfromURL(URL);
    return Mercado_Seleccionado;
}
	
@Override
protected void onPostExecute(JSONArray result) {
    //metodo que mas tarde se sobreescribira
}
	
}
