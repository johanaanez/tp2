package modelo.efectos;

public class EfectoNegrita extends EfectoSimple {

	public String decorar(String s) {
		return "<b>" + s + "</b>";
	}

}
