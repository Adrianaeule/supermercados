package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuOpcionesComercios extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_opciones_comercios);

        final Button boton_ayuda_menu_comercios = (Button)findViewById(R.id.Boton_Ayuda_Menu_Comercios);
        final ImageButton boton_observatorio = (ImageButton)findViewById(R.id.Imagen_Observatorio_Precios);
        final ImageButton boton_mercadillos = (ImageButton)findViewById(R.id.Imagen_Mercadillos);
        
        boton_ayuda_menu_comercios.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MenuOpcionesComercios.this, AyudaMenuComercios.class);
        		startActivity(intent);
        	}
        });
        
        boton_observatorio.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MenuOpcionesComercios.this, PantallaObservatorio1.class);
        		startActivity(intent);
        	}
        });
        
        boton_mercadillos.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MenuOpcionesComercios.this, PantallaMercadillos1.class);
        		startActivity(intent);
        	}
        });
    }
}
