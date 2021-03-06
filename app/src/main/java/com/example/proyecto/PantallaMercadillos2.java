package com.example.proyecto;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PantallaMercadillos2 extends android.support.v4.app.FragmentActivity{
	GoogleMap mapa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.mercadillos2);
	    
        final Button boton_ayuda_mercadillos2 = (Button)findViewById(R.id.Boton_Ayuda_Mercadillos2);

	    
	    boton_ayuda_mercadillos2.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaMercadillos2.this, AyudaPantallaMercadillos2.class);
        		startActivity(intent);
        	}
        });
	    
	    Bundle extra = this.getIntent().getExtras();
	    String IslaSeleccionada = extra.getString("com.example.proyecto.ISLA");
	    String CategoriaSeleccionada = extra.getString("com.example.proyecto.CATEGORIA");
	    
	    final TextView Isla = (TextView)findViewById(R.id.Isla);
	    final TextView Categoria = (TextView)findViewById(R.id.Categoria);
	    
	    String AuxIsla = Isla.getText().toString();
	    String AuxCategoria = Categoria.getText().toString();
        
	    AuxIsla += IslaSeleccionada;
	    AuxCategoria += CategoriaSeleccionada;
	    Isla.setText(AuxIsla);
	    Categoria.setText(AuxCategoria);
	    

	    ConsultaIsla consulta = new ConsultaIsla(){
	    	@Override
	        protected void onPostExecute(JSONObject result){
            	IncluirMapa(result); 
	    	}
        };
        consulta.execute(IslaSeleccionada);
        
        ConsultaMercados consulta2 = new ConsultaMercados(){
	    	@Override
	        protected void onPostExecute(JSONArray result){
            	IncluirMarcadores(result);
	    	}
                };
        consulta2.execute(IslaSeleccionada, CategoriaSeleccionada, false);
	}
	
	public void IncluirMapa(JSONObject result){
		double lng, lat;
		try{
			lng = result.getDouble("Longitud");
			lat = result.getDouble("Latitud");
            Log.i("DATOS", "Longitud: " + lng+ ", Latitud: "+lat);
        }
		catch(Exception ex){
        	Log.e("ServicioRest","Error al sacar los datos", ex);
			lng = 0.0;
			lat = 0.0;

        }
		 LatLng ProvinciaSeleccionadaMapa = new LatLng(lat,lng);
		 mapa =((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.MapaSupermercadosM)).getMap();
		 CameraPosition centrarmapa = new CameraPosition.Builder().target(ProvinciaSeleccionadaMapa).zoom(8).build();
		 CameraUpdate inicializar = CameraUpdateFactory.newCameraPosition(centrarmapa);
		 mapa.animateCamera(inicializar);
	}
	
	public void IncluirMarcadores(JSONArray result){
		double lng, lat;
		String nombre, dir;
		int tam = result.length();
        if (tam == 0){
            Toast toast = Toast.makeText(getApplicationContext(), "No existen datos para las opciones seleccionadas, vuelva a intentarlo", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    	for(int i = 0; i < tam; i++){
    		try{
                JSONObject obj = result.getJSONObject(i);
    			nombre = obj.getString("Nombre");
    			dir = obj.getString("Direccion");
    			lng = obj.getDouble("Longitud");
    			lat = obj.getDouble("Latitud");
                Log.i("eoooooooooooooooooooooooooooooo", "DATOS --> Nombre: "+nombre+ ", Direccion: "+dir+ ", Longitud: "+lng+ ", Latitud: "+lat);
    			Marker m = mapa.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title(nombre).snippet(dir));
    		}
    		catch(Exception ex){
    			Log.e("ServicioRest","Error al sacar los datos", ex);
    			lng = 0.0;
    			lat = 0.0;
    			nombre = "";
    			dir = "";
    		}

    	}
		
	}

}

