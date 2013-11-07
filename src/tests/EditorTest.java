package tests;

import modelo.Documento;
import modelo.Frase;
import modelo.Palabra;
import modelo.comandos.ComandoCopiar;
import modelo.comandos.ComandoCortar;
import modelo.efectos.EfectoCopiarFormato;
import modelo.efectos.EfectoItalica;
import modelo.efectos.EfectoNegrita;
import junit.framework.TestCase;

public class EditorTest extends TestCase {

	private Documento crearDocumento() {
		return new Documento();
	}

	private Palabra crearPalabraConString(String contenido) {
		return new Palabra(contenido);
	}

	private Frase crearFrase() {
		return new Frase();
	}

	private ComandoCopiar crearComandoCopiar() {
		return new ComandoCopiar();
	}

	private ComandoCortar crearComandoCortar() {
		return new ComandoCortar();
	}

	private EfectoItalica crearEfectoItalica() {
		return new EfectoItalica();
	}

	private EfectoNegrita crearEfectoNegrita() {
		return new EfectoNegrita();
	}

	private EfectoCopiarFormato crearEfectoCopiarFormato() {
		return new EfectoCopiarFormato();
	}

	public void test_001_documentoVacio() {
		Documento unDoc = crearDocumento();
		assertEquals("", unDoc.contenidoComoString());
	}

	public void test_002_documentoConPalabra() {
		Documento unDoc = crearDocumento();
		Palabra unaPalabra = crearPalabraConString("hola");
		unDoc.sumarContenido(unaPalabra);
		assertEquals("hola", unaPalabra.contenidoComoString());
		assertEquals("hola", unDoc.contenidoComoString());
	}

	public void test_003_documentoConFrase() {
		Documento unDoc = crearDocumento();

		Palabra unaPalabra = crearPalabraConString("hola");

		Palabra otraPalabra = crearPalabraConString("mundo");

		Frase unaFrase = crearFrase();

		unaFrase.sumarContenido(unaPalabra);
		unaFrase.sumarContenido(otraPalabra);

		unDoc.sumarContenido(unaFrase);

		assertEquals("hola mundo", unaFrase.contenidoComoString());

		assertEquals("hola mundo", unDoc.contenidoComoString());
	}

	public void test_004_documentoConFrases() {
		Documento unDoc = crearDocumento();

		Palabra unaPalabra = crearPalabraConString("hola");

		Palabra otraPalabra = crearPalabraConString("mundo");

		Frase unaFrase = crearFrase();
		unaFrase.sumarContenido(unaPalabra);

		Frase otraFrase = crearFrase();
		otraFrase.sumarContenido(otraPalabra);

		unDoc.sumarContenido(unaFrase);
		unDoc.sumarContenido(otraFrase);

		assertEquals("hola", unaFrase.contenidoComoString());

		assertEquals("mundo", otraFrase.contenidoComoString());

		assertEquals("hola mundo", unDoc.contenidoComoString());
	}

	public void test_005_comandoCopiar() {
		Documento unDoc = crearDocumento();

		Frase unaFrase = crearFrase();
		unaFrase.sumarContenido(crearPalabraConString("hola"));
		unaFrase.sumarContenido(crearPalabraConString("mundo"));

		Frase otraFrase = crearFrase();
		otraFrase.sumarContenido(crearPalabraConString("chau"));

		unDoc.sumarContenido(unaFrase);
		unDoc.sumarContenido(otraFrase);

		assertEquals("hola mundo chau", unDoc.contenidoComoString());

		Palabra unaPalabra = unaFrase.getPalabraEnPosicion(2);

		ComandoCopiar unComandoCopiar = crearComandoCopiar();

		unComandoCopiar.copiar(unaPalabra);
		unComandoCopiar.pegarAlFinalDe(otraFrase);

		assertEquals("hola mundo chau mundo", unDoc.contenidoComoString());
	}

	public void test_006_comandoCortar() {
		Documento unDoc = crearDocumento();

		Frase unaFrase = crearFrase();
		unaFrase.sumarContenido(crearPalabraConString("hola"));
		unaFrase.sumarContenido(crearPalabraConString("mundo"));

		Frase otraFrase = crearFrase();
		otraFrase.sumarContenido(crearPalabraConString("chau"));

		unDoc.sumarContenido(unaFrase);
		unDoc.sumarContenido(otraFrase);

		assertEquals("hola mundo chau", unDoc.contenidoComoString());

		Palabra unaPalabra = unaFrase.getPalabraEnPosicion(2);

		ComandoCortar unComandoCortar = crearComandoCortar();

		unComandoCortar.cortar(unaPalabra);
		unComandoCortar.pegarAlFinalDe(otraFrase);

		assertEquals("hola chau mundo", unDoc.contenidoComoString());
	}

	public void test_007_efectoItalica() {
		Documento unDoc = crearDocumento();

		Frase unaFrase = crearFrase();
		unaFrase.sumarContenido(crearPalabraConString("hola"));
		unaFrase.sumarContenido(crearPalabraConString("mundo"));

		unDoc.sumarContenido(unaFrase);

		EfectoItalica unEfectoItalica = crearEfectoItalica();

		unEfectoItalica.aplicarA(unaFrase);

		assertEquals("<i>hola</i> <i>mundo</i>", unDoc.contenidoComoString());
	}

	public void test_008_multiplesEfectos() {
		Documento unDoc = crearDocumento();

		Frase unaFrase = crearFrase();
		unaFrase.sumarContenido(crearPalabraConString("hola"));
		unaFrase.sumarContenido(crearPalabraConString("mundo"));

		unDoc.sumarContenido(unaFrase);

		EfectoItalica unEfectoItalica = crearEfectoItalica();
		unEfectoItalica.aplicarA(unaFrase);

		Palabra unaPalabra = unaFrase.getPalabraEnPosicion(2);

		EfectoNegrita unEfectoNegrita = crearEfectoNegrita();
		unEfectoNegrita.aplicarA(unaPalabra);

		assertEquals("<i>hola</i> <b><i>mundo</i></b>", unDoc.contenidoComoString());
	}

	public void test_009_efectoCopiarFormato() {
		Documento unDoc = crearDocumento();

		Frase unaFrase = crearFrase();
		unaFrase.sumarContenido(crearPalabraConString("hola"));
		unaFrase.sumarContenido(crearPalabraConString("mundo"));

		Frase otraFrase = crearFrase();
		otraFrase.sumarContenido(crearPalabraConString("chau"));
		otraFrase.sumarContenido(crearPalabraConString("mundo"));

		unDoc.sumarContenido(unaFrase);
		unDoc.sumarContenido(otraFrase);

		EfectoItalica unEfectoItalica = crearEfectoItalica();
		unEfectoItalica.aplicarA(unaFrase);

		EfectoNegrita unEfectoNegrita = crearEfectoNegrita();
		unEfectoNegrita.aplicarA(otraFrase);

		assertEquals("<i>hola</i> <i>mundo</i> <b>chau</b> <b>mundo</b>", unDoc.contenidoComoString());

		EfectoCopiarFormato unEfectoCopiarFormato = crearEfectoCopiarFormato();

		Palabra unaPalabra = unaFrase.getPalabraEnPosicion(1);

		unEfectoCopiarFormato.copiarDe(unaPalabra);
		unEfectoCopiarFormato.aplicarA(otraFrase);

		assertEquals("<i>hola</i> <i>mundo</i> <i>chau</i> <i>mundo</i>", unDoc.contenidoComoString());
	}

}
