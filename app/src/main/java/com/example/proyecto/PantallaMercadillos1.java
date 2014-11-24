package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class PantallaMercadillos1 extends Activity {
	String Isla_sel;
	String Categoria_sel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.mercadillos1);
	    
        final Button boton_ayuda_mercadillos1 = (Button)findViewById(R.id.Boton_Ayuda_Mercadillos1);

        boton_ayuda_mercadillos1.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaMercadillos1.this, AyudaPantallaMercadillos1.class);
        		startActivity(intent);
        	}
        });
	    
	    
	    ArrayAdapter<CharSequence> adaptador_islas = ArrayAdapter.createFromResource(this, R.array.islas_canarias, android.R.layout.simple_spinner_item);
		final Spinner listaIslas = (Spinner)findViewById(R.id.Opciones_Isla);
	    adaptador_islas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listaIslas.setAdapter(adaptador_islas);
		
		listaIslas.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
				Isla_sel = parent.getItemAtPosition(pos).toString();
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
        		Intent intent = new Intent(PantallaMercadillos1.this, PantallaMercadillos2.class);
        		intent.putExtra("com.example.proyecto.ISLA", Isla_sel);
        		intent.putExtra("com.example.proyecto.CATEGORIA", Categoria_sel);
        		startActivity(intent);
        	}
        });

	}      
}
