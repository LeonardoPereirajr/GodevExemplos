package descontos;

import static org.junit.Assert.*;

import org.junit.Test;

public class descontosteste {

	@Test
	public void test() {
		double calculaInss = descontosFolha.descontoInss(0.11, 3000.00);
		assertEquals(calculaInss, 330, 0);
	}

	@Test
	public void test2() {
		double calculaInss = descontosFolha.descontoInss(0.11, 3000);
		assertNotEquals(calculaInss, 110, 0);
	}

	@Test
	public void test3() {
		double valeTransporte = descontosFolha.vt(180, 3000);
		assertEquals(valeTransporte, 180, 0);
	}

	@Test
	public void test4() {
		double valeTransporte = descontosFolha.vt(180, 3000);
		assertNotEquals(valeTransporte, 250, 0.06);
	}
	
	@Test
	public void test5() {
		double valorDiferencaSalario = outrosDescontos.valorHorasExtras(10.00, 8, 0.50);
		assertEquals(valorDiferencaSalario,120,0);
	}
	
	@Test
	public void test6() {
		double valorSalarioInicial = outrosDescontos.calculaHorasTrabalhadas(40, 10);
		assertEquals(valorSalarioInicial,400,0);
	}


}
