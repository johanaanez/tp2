package modelo.efectos;

import modelo.Contenido;

public abstract class EfectoSimple {

	public void aplicarA(Contenido unContenido) {
		unContenido.agregarEfecto(this);
	}
	
	public abstract String decorar(String s); 
	
}
