package modelo.comandos;

import modelo.Contenido;

public class ComandoCortar extends ComandoPegar {

	public void cortar(Contenido unContenido) {
		contenido = unContenido;
		unContenido.removerDeContenedor();
	}
	
}
