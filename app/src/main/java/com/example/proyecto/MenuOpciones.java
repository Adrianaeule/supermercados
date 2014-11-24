package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuOpciones extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_opciones);

        final Button boton_ayuda_menu_opciones = (Button)findViewById(R.id.Boton_Ayuda_Menu_Opciones);
        final ImageButton boton_comercios = (ImageButton)findViewById(R.id.Imagen_Comercios);
        final ImageButton boton_productos = (ImageButton)findViewById(R.id.Imagen_Productos);
        
        boton_ayuda_menu_opciones.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MenuOpciones.this, AyudaMenuOpciones.class);
        		startActivity(intent);
        	}
        });
        
        boton_comercios.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MenuOpciones.this, MenuOpcionesComercios.class);
        		startActivity(intent);
        	}
        });
        
        boton_productos.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MenuOpciones.this, PantallaPCanarios1.class);
        		startActivity(intent);
        	}
        });
    }
}
