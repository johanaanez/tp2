package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.efectos.EfectoSimple;


public class Palabra implements Contenido {

	private String miString;
	private Contenedor contenedor;
	private List<EfectoSimple> efectos;
	
	public Palabra(String contenido) {
		this.miString = contenido;
		efectos = new ArrayList<EfectoSimple>();
	}
	
	public String contenidoComoString() {
		String resultado = miString;
		for (EfectoSimple unEfecto : efectos) {
			resultado = unEfecto.decorar(resultado);
		}
		return resultado;
	}

	public Contenido copiar() {
		Palabra copia = new Palabra(this.miString);
		return copia;
	}

	public void setearContenedor(Contenedor c) {
		contenedor = c;
	}

	public void removerDeContenedor() {
		contenedor.removerContenido(this);
	}

	public void agregarEfecto(EfectoSimple unEfecto) {
		efectos.add(unEfecto);
	}
	
	public void reemplazarEfectos(List<EfectoSimple> efectos) {
		this.efectos = efectos;
	}

	public List<EfectoSimple> getEfectos() {
		return efectos;
	}
	
}
