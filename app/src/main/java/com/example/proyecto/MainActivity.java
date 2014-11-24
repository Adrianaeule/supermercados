package com.example.proyecto;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button boton_ayuda_principal = (Button)findViewById(R.id.Boton_Ayuda_Principal);
        final Button boton_acceso_app = (Button)findViewById(R.id.Boton_Acceso_App);

        boton_ayuda_principal.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MainActivity.this, AyudaPrincipal.class);
        		startActivity(intent);
        	}
        });
        
        boton_acceso_app.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(MainActivity.this, MenuOpciones.class);
        		startActivity(intent);
        	}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
