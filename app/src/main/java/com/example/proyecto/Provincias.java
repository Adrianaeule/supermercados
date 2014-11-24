package com.example.proyecto;

public class Provincias {
		public String provincia;
		public double longitud;
		public double latitud;
		public float zoom;		
		
		public Provincias()
		{
			provincia = "";
			longitud = 0.0;
			latitud = 0.0;
			zoom = 0;
		}

		public Provincias(String provincia, double longitud, double latitud, float zoom)
		{
			this.provincia = provincia;
			this.longitud = longitud;
			this.latitud = latitud;
			this.zoom = zoom;
		}
}
