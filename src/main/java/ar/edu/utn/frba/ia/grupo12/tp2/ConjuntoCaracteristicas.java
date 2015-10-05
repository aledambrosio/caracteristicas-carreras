/*
 * Fluxit S.A
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: alejandro
 * Date:  Oct 4, 2015 - 7:23:13 PM
 */
package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.Random;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

/**
 * @author Alejandro D'Ambrosio
 *
 */
public class ConjuntoCaracteristicas extends Individuo {
	private Integer materiasDuras;
	private Integer materiasBlandas;
	private Integer ofertaDemanda;
	private Integer duracionPromedio;
	private Integer satisfaccionEconomica;
	
	@Override
	public double aptitud() {
		return this.getMateriasDuras() + 
				this.getMateriasBlandas() +
				this.getOfertaDemanda() + 
				this.getDuracionPromedio() + 
				this.getSatisfaccionEconomica();
	}
	
	@Override
	public Individuo generarRandom() {
		Random r = new Random();
		int Low = 1;
		int High = 5;
		ConjuntoCaracteristicas cc = new ConjuntoCaracteristicas();
		cc.setMateriasDuras(r.nextInt(High-Low) + Low);
		cc.setMateriasBlandas(r.nextInt(High-Low) + Low);
		cc.setOfertaDemanda(r.nextInt(High-Low) + Low);
		cc.setDuracionPromedio(r.nextInt(High-Low) + Low);
		cc.setSatisfaccionEconomica(r.nextInt(High-Low) + Low);
		
		return cc;
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

}
