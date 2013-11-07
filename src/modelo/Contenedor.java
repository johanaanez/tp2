package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.efectos.EfectoSimple;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Contenedor implements Contenido {

	protected List<Contenido> contenidos;
	public Contenedor() {
		contenidos = new ArrayList<Contenido>();
	}
	
	public void sumarContenido(Contenido unContenido) {
		unContenido.setearContenedor(this);
		contenidos.add(unContenido);
	}
	
	public String contenidoComoString() {
		String resultado = "";
		if (contenidos.size() > 0) {
			resultado = contenidos.get(0).contenidoComoString();
		}
		for (int i = 1; i < contenidos.size(); i++) {
			resultado = resultado + " " + contenidos.get(i).contenidoComoString();
		}
		return resultado;
	}

	public void removerContenido(Contenido unContenido) {
		contenidos.remove(unContenido);
	}

	public void setearContenedor(Contenedor unContenedor) {
	}

	public void agregarEfecto(EfectoSimple unEfecto) {
		for (Contenido unContenido : contenidos) {
			unContenido.agregarEfecto(unEfecto);
		}
	}

	public void reemplazarEfectos(List<EfectoSimple> efectos) {
		for (Contenido unContenido : contenidos) {
			unContenido.reemplazarEfectos(efectos);
		}
	}
	
	public Contenido copiar() {
		// estamos obligados a implementar esto por implementar Contenido
		// es feo lanzar esta exception... pero esto no se va a llamar nunca 
		throw new NotImplementedException();
	}

	public void removerDeContenedor() {
		// estamos obligados a implementar esto por implementar Contenido
		// es feo lanzar esta exception... pero esto no se va a llamar nunca 
		throw new NotImplementedException();
	}

	public List<EfectoSimple> getEfectos() {
		// estamos obligados a implementar esto por implementar Contenido
		// es feo lanzar esta exception... pero esto no se va a llamar nunca 
		throw new NotImplementedException();
	}


}
