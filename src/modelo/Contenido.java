package modelo;

import java.util.List;

import modelo.efectos.EfectoSimple;


public interface Contenido {

	public String contenidoComoString();
	public Contenido copiar();
	public void setearContenedor(Contenedor unContenedor);
	public void removerDeContenedor();
	public void agregarEfecto(EfectoSimple unEfecto);
	public List<EfectoSimple> getEfectos();
	public void reemplazarEfectos(List<EfectoSimple> efectos);
	
}
