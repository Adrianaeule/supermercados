package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class PantallaPCanarios1 extends Activity implements OnItemSelectedListener{
	String Isla_sel;
	String Categoria_sel;
	String Producto_sel;
    boolean Mercadillo_sel;
    private Spinner listaProductos, listaCategorias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.pcanarios1);
	    
	    final Button boton_ayuda_pcanarios1 = (Button)findViewById(R.id.Boton_Ayuda_PCanarios1);

        boton_ayuda_pcanarios1.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaPCanarios1.this, AyudaPantallaPCanarios1.class);
        		startActivity(intent);
        	}
        });  
	    
	    ArrayAdapter<CharSequence> adaptador_islas = ArrayAdapter.createFromResource(this, R.array.islas_canarias, android.R.layout.simple_spinner_item);
		final Spinner listaIslas = (Spinner)findViewById(R.id.Opciones_Islas);
	    adaptador_islas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listaIslas.setAdapter(adaptador_islas);
		
		listaIslas.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
				Isla_sel = parent.getItemAtPosition(pos).toString();
			}
			public void onNothingSelected(AdapterView<?> parent){
				
			}
		});

        this.listaCategorias = (Spinner)findViewById(R.id.Opciones_Categoria);
        this.listaProductos = (Spinner)findViewById(R.id.Opciones_Producto);

        ArrayAdapter<CharSequence> adaptador_categorias = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);
        adaptador_categorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.listaCategorias.setAdapter(adaptador_categorias);

        this.listaCategorias.setOnItemSelectedListener(this);
        this.listaProductos.setOnItemSelectedListener(this);
		
		final CheckBox Mercadillos_sel = (CheckBox)findViewById(R.id.Seleccion_Mercadillos);
		Mercadillos_sel.setOnClickListener(new View.OnClickListener() {
	          public void onClick(View arg0) {
	              if (Mercadillos_sel.isChecked()) {
	            	  Mercadillo_sel = true;
	              }
	              else {
	            	  Mercadillo_sel = false;
	              }
	          }
	    });
		
        final Button boton_aceptar = (Button)findViewById(R.id.Boton_Aceptar);
        boton_aceptar.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent(PantallaPCanarios1.this, PantallaPCanarios2.class);
        		intent.putExtra("com.example.proyecto.ISLA", Isla_sel);
        		intent.putExtra("com.example.proyecto.CATEGORIA", Categoria_sel);
        		intent.putExtra("com.example.proyecto.PRODUCTO", Producto_sel);
        		intent.putExtra("com.example.proyecto.MERCADILLO", Mercadillo_sel);
        		startActivity(intent);
        	}
        });

	}
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        switch (parent.getId()) {
            case R.id.Opciones_Categoria:
                // Retrieves an array
                Categoria_sel = parent.getItemAtPosition(pos).toString();
                TypedArray arrayCategorias = getResources().obtainTypedArray(R.array.categorias_productos);
                CharSequence[] productos = arrayCategorias.getTextArray(pos);
                arrayCategorias.recycle();

                // Create an ArrayAdapter using the string array and a default
                // spinner layout
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                        this, android.R.layout.simple_spinner_item,
                        android.R.id.text1, productos);

                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Apply the adapter to the spinner
                this.listaProductos.setAdapter(adapter);
                break;

            case R.id.Opciones_Producto:
                Producto_sel = parent.getItemAtPosition(pos).toString(); //MIRAR PORQUE NO ME CAMBIA ESTE VALOR!!
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
