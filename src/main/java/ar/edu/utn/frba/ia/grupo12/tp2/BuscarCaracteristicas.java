package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzar;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;

public class BuscarCaracteristicas {
	static final int poblacionInicial = 3000;

	public static void main(String[] args) {
		ConfiguracionDefault c = new ConfiguracionDefault();
		
		c.setCriterioDeParo(new CantidadDeCiclos(499L));
		c.setPoblacionInicial(poblacionInicial);
		c.setMetodoDeSeleccion(new Ranking(Math.round((float)(poblacionInicial * 1.5))));
		c.setMutacion(new MutacionSimple(0.3));
		c.setCruzamiento(new BinomialAzar());
		
		AlgoritmoGenetico buscaCaracteristicas = new AlgoritmoGenetico(c, ConjuntoCaracteristicas.class);
		
		Individuo caracteristicas = buscaCaracteristicas.ejecutar();

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + caracteristicas.toString());
	}

}
