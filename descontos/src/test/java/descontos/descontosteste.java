package descontos;

import static org.junit.Assert.*;

import org.junit.Test;

public class descontosteste {

	@Test
	public void testeDescontoInssIgual() {
		double calculaInss = descontosFolha.descontoInss(0.11, 3000);
		assertEquals(calculaInss, 330, 0);
	}

	@Test
	public void testeDescontoInss() {
		double calculaInss = descontosFolha.descontoInss(0.11, 3000);
		assertNotEquals(calculaInss, 110, 0);
	}

	@Test
	public void testeValeTransporteIgual() {
		double valeTransporte = descontosFolha.vt(180, 3000);
		assertEquals(valeTransporte, 180, 0);
	}

	@Test
	public void testeValeTransporte() {
		double valeTransporte = descontosFolha.vt(180, 3000);
		assertNotEquals(valeTransporte, 250, 0.06);
	}

	@Test
	public void testeValorHorasExtras() {
		double valorDiferencaSalario = outrosDescontos.valorHorasExtras(10.00, 8, 0.50);
		assertEquals(valorDiferencaSalario, 120, 0);
	}

	@Test
	public void testeCalculaHorasTrabalhadas() {
		double valorSalarioInicial = outrosDescontos.calculaHorasTrabalhadas(40, 10);
		assertEquals(valorSalarioInicial, 400, 0);
	}

	@Test
	public void testeImprimeFolha() {

	}

}
