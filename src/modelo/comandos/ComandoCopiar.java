package modelo.comandos;

import modelo.Contenido;

public class ComandoCopiar extends ComandoPegar {

	public void copiar(Contenido unContenido) {
		contenido = unContenido.copiar();
	}

}
