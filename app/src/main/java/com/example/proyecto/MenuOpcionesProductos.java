package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuOpcionesProductos extends Activity{
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_opciones_productos);
	        
	        final ImageButton boton_pcanarios = (ImageButton)findViewById(R.id.Imagen_Productos_Canarios);

	        boton_pcanarios.setOnClickListener(new View.OnClickListener(){
	        	@Override
	        	public void onClick(View v){
	        		Intent intent = new Intent(MenuOpcionesProductos.this, PantallaPCanarios1.class);
	        		startActivity(intent);
	        	}
	        });
	}
}