package modelo.efectos;

public class EfectoItalica extends EfectoSimple {

	public String decorar(String s) {
		return "<i>" + s + "</i>";
	}
	
}
