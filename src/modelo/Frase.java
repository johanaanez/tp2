package modelo;

public class Frase extends Contenedor {

	public Palabra getPalabraEnPosicion(int i) {
		// suponemos que siempre vamos a tener palabras como contenidos
		return (Palabra)contenidos.get(i-1);
	}

}
