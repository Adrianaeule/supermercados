package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class PantallaLogin extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        final Button boton_ayuda_acceso = (Button)findViewById(R.id.Boton_Ayuda_Acceso);
        final Button boton_acceso = (Button)findViewById(R.id.Boton_Acceso);
        
        boton_ayuda_acceso.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaLogin.this, AyudaLogin.class);
        		startActivity(intent);
        	}
        });  
        
        
        boton_acceso.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaLogin.this, MenuOpciones.class);
        		startActivity(intent);
        	}
        });

    }
}
