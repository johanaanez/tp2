package modelo.comandos;

import modelo.Contenedor;
import modelo.Contenido;

public abstract class ComandoPegar {
	
	protected Contenido contenido;
	
	public void pegarAlFinalDe(Contenedor unContenedor) {
		unContenedor.sumarContenido(contenido);
	}
	
}
