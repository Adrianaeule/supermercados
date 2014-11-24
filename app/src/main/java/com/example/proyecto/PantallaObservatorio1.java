package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;

public class PantallaObservatorio1 extends Activity {
	String Provincia_sel;
	String Categoria_sel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.observatorio1);
	    
        final Button boton_ayuda_observatorio1 = (Button)findViewById(R.id.Boton_Ayuda_Observatorio1);

        boton_ayuda_observatorio1.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaObservatorio1.this, AyudaPantallaObservatorio1.class);
        		startActivity(intent);
        	}
        });
        
	    ArrayAdapter<CharSequence> adaptador_provincias = ArrayAdapter.createFromResource(this, R.array.provincias_espana, android.R.layout.simple_spinner_item);
		final Spinner listaProvincias = (Spinner)findViewById(R.id.Opciones_Provincia);
	    adaptador_provincias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listaProvincias.setAdapter(adaptador_provincias);
		
		listaProvincias.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
				Provincia_sel = parent.getItemAtPosition(pos).toString();
			}
			public void onNothingSelected(AdapterView<?> parent){
				
			}
		});
		
		
	    ArrayAdapter<CharSequence> adaptador_categorias = ArrayAdapter.createFromResource(this, R.array.categorias_observatorio_precio, android.R.layout.simple_spinner_item);
		final Spinner listaCategorias = (Spinner)findViewById(R.id.Opciones_Categoria);
	    adaptador_categorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listaCategorias.setAdapter(adaptador_categorias);
		
		listaCategorias.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
				Categoria_sel = parent.getItemAtPosition(pos).toString();		
			}
			public void onNothingSelected(AdapterView<?> parent){
				
			}
		});	
		
		
        final Button boton_aceptar = (Button)findViewById(R.id.Boton_Aceptar);
        boton_aceptar.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaObservatorio1.this, PantallaObservatorio2.class);
        		intent.putExtra("com.example.proyecto.PROVINCIA", Provincia_sel);
        		intent.putExtra("com.example.proyecto.CATEGORIA", Categoria_sel);
        		startActivity(intent);
        	}
        });

	}      
}
