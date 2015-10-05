/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: alejandro
 * Date:  Oct 4, 2015 - 7:23:13 PM
 */
package ar.edu.utn.frba.ia.grupo12.tp2;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;


/**
 * @author Alejandro D'Ambrosio
 *
 */
public class Caracteristicas extends Individuo {
	private static Caracteristicas cromosomaIdeal = null;
	private Integer materiasDuras;
	private Integer materiasBlandas;
	private Integer ofertaDemanda;
	private Integer duracionPromedio;
	private Integer satisfaccionEconomica;

	public static Caracteristicas getCromosomaIdeal() {
		if (cromosomaIdeal == null) {
			cromosomaIdeal = new Caracteristicas();
			cromosomaIdeal.initCromosomaIdeal();
		}
		return cromosomaIdeal;
	}
	public void initCromosomaIdeal() {
		this.setMateriasDuras(3);
		this.setMateriasBlandas(3);
		this.setOfertaDemanda(4);
		this.setDuracionPromedio(3);
		this.setSatisfaccionEconomica(4);
	}
	
	public Integer getMateriasDuras() {
		return materiasDuras;
	}

	public void setMateriasDuras(Integer materiasDuras) {
		this.materiasDuras = materiasDuras;
	}

	public Integer getMateriasBlandas() {
		return materiasBlandas;
	}

	public void setMateriasBlandas(Integer materiasBlandas) {
		this.materiasBlandas = materiasBlandas;
	}

	public Integer getOfertaDemanda() {
		return ofertaDemanda;
	}

	public void setOfertaDemanda(Integer ofertaDemanda) {
		this.ofertaDemanda = ofertaDemanda;
	}

	public Integer getDuracionPromedio() {
		return duracionPromedio;
	}

	public void setDuracionPromedio(Integer duracionPromedio) {
		this.duracionPromedio = duracionPromedio;
	}

	public Integer getSatisfaccionEconomica() {
		return satisfaccionEconomica;
	}

	public void setSatisfaccionEconomica(Integer satisfaccionEconomica) {
		this.satisfaccionEconomica = satisfaccionEconomica;
	}

	@Override
	public double aptitud() {
		return 0;
	}
}
