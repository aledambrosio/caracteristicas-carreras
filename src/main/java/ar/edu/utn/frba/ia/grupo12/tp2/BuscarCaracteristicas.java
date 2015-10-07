package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzarComplemento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionTemperaturaAscendente;
import main.java.ar.edu.utn.frba.ia.ag.paro.TiempoTranscurrido;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;

public class BuscarCaracteristicas {
	static final int poblacionInicial = 3000;

	public static void main(String[] args) {
		ConfiguracionDefault c = new ConfiguracionDefault();
		
		c.setPoblacionInicial(poblacionInicial);
//		c.setCriterioDeParo(new CantidadDeCiclos(499L));
//		c.setMetodoDeSeleccion(new Ranking(Math.round((float)(poblacionInicial * 1.5))));
//		c.setMutacion(new MutacionSimple(0.2));
//		c.setCruzamiento(new BinomialAzar());
		
//		c.setCriterioDeParo(new AptitudMinimaPromedio(70));
//		c.setMetodoDeSeleccion(new Ruleta());
//		c.setMutacion(new MutacionAdaptativaPorConvergencia());
//		c.setCruzamiento(new Simple());

		c.setCriterioDeParo(new TiempoTranscurrido(0, 2, 0) );
		c.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
		c.setMutacion(new MutacionTemperaturaAscendente());
		c.setCruzamiento(new BinomialAzarComplemento());
		
		AlgoritmoGenetico buscaCaracteristicas = new AlgoritmoGenetico(c, ConjuntoCaracteristicas.class);
		
		Individuo caracteristicas = buscaCaracteristicas.ejecutar();

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + caracteristicas.toString());
	}

}
