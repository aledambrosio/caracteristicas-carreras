package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzar;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzarComplemento;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionAdaptativaPorConvergencia;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionTemperaturaAscendente;
import main.java.ar.edu.utn.frba.ia.ag.paro.AptitudMinimaPromedio;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.paro.TiempoTranscurrido;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ruleta;

public class BuscarCaracteristicas {
	static final int poblacionInicial = 3000;

	public static void main(String[] args) {
		ConfiguracionDefault c = new ConfiguracionDefault();
		
		c.setPoblacionInicial(poblacionInicial);
		
		//Primer ejecución
		c.setCriterioDeParo(new CantidadDeCiclos(499L));
		c.setMetodoDeSeleccion(new Ranking(Math.round((float)(poblacionInicial * 1.5))));
		c.setMutacion(new MutacionSimple(0.2));
		c.setCruzamiento(new BinomialAzar());

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("*** Primer ejecución ***");
		crearYEjecutar(c);
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("*** FIN primer ejecución ***");
		
		//Segunda ejecución
		c.setCriterioDeParo(new AptitudMinimaPromedio(70));
		c.setMetodoDeSeleccion(new Ruleta());
		c.setMutacion(new MutacionAdaptativaPorConvergencia());
		c.setCruzamiento(new Simple());

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("*** Segunda ejecución ***");
		crearYEjecutar(c);
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("*** FIN segunda ejecución ***");

		//Tercer ejecución
		c.setCriterioDeParo(new TiempoTranscurrido(0, 2, 0) );
		c.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
		c.setMutacion(new MutacionTemperaturaAscendente());
		c.setCruzamiento(new BinomialAzarComplemento());
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("*** Tercer ejecución ***");
		crearYEjecutar(c);
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("*** FIN Tercer ejecución ***");
	}

	private static void crearYEjecutar(ConfiguracionDefault c) {
		AlgoritmoGenetico buscaCaracteristicas = new AlgoritmoGenetico(c, ConjuntoCaracteristicas.class);
		
		Individuo caracteristicas = buscaCaracteristicas.ejecutar();

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + caracteristicas.toString());
	}

}
