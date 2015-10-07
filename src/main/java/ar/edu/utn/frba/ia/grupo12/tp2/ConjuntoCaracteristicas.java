package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author Alejandro D'Ambrosio
 *
 */
public class ConjuntoCaracteristicas extends Individuo {
	protected Integer materiasDuras;
	protected Integer materiasBlandas;
	protected Integer ofertaDemanda;
	protected Integer duracionPromedio;
	protected Integer satisfaccionEconomica;
	
	public ConjuntoCaracteristicas() {
	}

	@Override
	public double aptitud() {
		Integer temp = 0, value = 0;
		try {
			
			ConjuntoCaracteristicas ideal = Utils.getCromosomaIdeal();
			//Materias Duras
			temp = this.getMateriasDuras() - ideal.getMateriasDuras();
			if (temp == 0) {
				value += 5;
			} else if (temp > 0) {
				value += (temp * -6);
			} else {
				value += (temp * -3);
			}
	
			//Materias Blandas
			temp = Math.abs(this.getMateriasBlandas() - ideal.getMateriasBlandas());
			if (temp == 0) {
				value += 5;
			} else {
				value += (temp * -3);
			}
			
			//Rel Oferta Demanda
			temp = Math.abs(this.getOfertaDemanda() - ideal.getOfertaDemanda());
			if (temp >= 0) {
				value += (temp * 8) + 5;
			} else {
				value += (temp * -9);
			}
			
			//Satisfac Econom.
			temp = Math.abs(this.getSatisfaccionEconomica() - ideal.getSatisfaccionEconomica());
			if (temp >= 0) {
				value += (temp * 10) + 5;
			} else {
				value += (temp * -10);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return value;
	}
	
	@Override
	public Individuo generarRandom() {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.FINE, "Se generó data del individio" + super.toString());
		Random r = new Random();
		int low = 1;
		int high = 5;
		ConjuntoCaracteristicas cc = this;
		cc.setMateriasDuras(r.nextInt(high-low) + low);
		cc.setMateriasBlandas(r.nextInt(high-low) + low);
		cc.setOfertaDemanda(r.nextInt(high-low) + low);
		cc.setDuracionPromedio(r.nextInt(high-low) + low);
		cc.setSatisfaccionEconomica(r.nextInt(high-low) + low);
		
		return cc;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(29845, 71);
		hcb.append(this.getMateriasDuras())
			.append(this.getMateriasBlandas())
			.append(this.getOfertaDemanda())
			.append(this.getDuracionPromedio())
			.append(this.getSatisfaccionEconomica());
		return super.hashCode();
	}
	
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		sb.append("Materias Duras", this.getMateriasDuras())
		.append("Materias Blandas", this.getMateriasBlandas())
		.append("Rel Oferta Demanda", this.getOfertaDemanda())
		.append("Duración Promedio", this.getDuracionPromedio())
		.append("Satisfacción Económica", this.getSatisfaccionEconomica());
		return sb.build();
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
	
	private static class Utils {
		private static ConjuntoCaracteristicas cromosomaIdeal = null;
		
		public synchronized static ConjuntoCaracteristicas getCromosomaIdeal() {
			if (cromosomaIdeal == null) {
				cromosomaIdeal = new ConjuntoCaracteristicas();
				initCromosomaIdeal(cromosomaIdeal);
			}
			return cromosomaIdeal;
		}
		private static void initCromosomaIdeal(ConjuntoCaracteristicas cc) {
			cc.setMateriasDuras(3);
			cc.setMateriasBlandas(3);
			cc.setOfertaDemanda(4);
			cc.setDuracionPromedio(3);
			cc.setSatisfaccionEconomica(4);
		}
	}
}
