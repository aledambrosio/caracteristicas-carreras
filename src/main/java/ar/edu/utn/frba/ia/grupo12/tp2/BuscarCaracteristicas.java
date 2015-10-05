package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

public class BuscarCaracteristicas {

	public static void main(String[] args) {
		AlgoritmoGenetico buscaCaracteristicas = new AlgoritmoGenetico(new BCConfiguracion(), ConjuntoCaracteristicas.class);
		
		Individuo caracteristicas = buscaCaracteristicas.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + caracteristicas.toString());
	}


	public static class BCConfiguracion extends Configuracion {

		public BCConfiguracion() {
			super(new CantidadDeCiclos(99L), // criterio de paro
					999, // cantIndividuosIniciales
					new Torneo(), // seleccion
					new Simple(), // cruzamiento
					new MutacionSimple(0.2)); // mutacion
		}

	}
}
