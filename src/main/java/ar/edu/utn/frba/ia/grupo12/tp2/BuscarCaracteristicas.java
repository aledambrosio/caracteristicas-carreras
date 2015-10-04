package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class BuscarCaracteristicas {

	public static void main(String[] args) {
		AlgoritmoGenetico buscaCaracteristicas = new AlgoritmoGenetico(new ConfiguracionDefault(), ConjuntoCaracteristicas.class);
		
		Individuo caracteristicas = buscaCaracteristicas.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + caracteristicas.toString());
		
	}

}
