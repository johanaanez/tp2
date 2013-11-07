package modelo.efectos;

import java.util.ArrayList;
import java.util.List;

import modelo.Contenido;

public class EfectoCopiarFormato {

	private List<EfectoSimple> efectosCopiados;

	public void copiarDe(Contenido unContenido) {
		efectosCopiados = new ArrayList<EfectoSimple>();
		efectosCopiados.addAll(unContenido.getEfectos());
	}

	public void aplicarA(Contenido unContenido) {
		unContenido.reemplazarEfectos(efectosCopiados);
	}

}
