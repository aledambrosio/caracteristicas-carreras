package ar.edu.utn.frba.ia.grupo12.tp2;

import java.util.Random;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author Alejandro D'Ambrosio
 *
 */
public class ConjuntoCaracteristicas extends Caracteristicas {

	@Override
	public double aptitud() {
		Caracteristicas ideal = Caracteristicas.getCromosomaIdeal();
		Integer temp, value = 0;
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

		return value;
	}
	
	@Override
	public Individuo generarRandom() {
		Random r = new Random();
		int low = 1;
		int high = 5;
		Caracteristicas cc = new ConjuntoCaracteristicas();
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
		ToStringBuilder sb = new ToStringBuilder(this);
		sb.append("Materias Duras: ", this.getMateriasDuras())
		.append("Materias Blandas: ", this.getMateriasBlandas())
		.append("Rel Oferta Demanda: ", this.getOfertaDemanda())
		.append("Duración Promedio: ", this.getDuracionPromedio())
		.append("Satisfacción Económica: ", this.getSatisfaccionEconomica());
		return sb.build();
	};
}
