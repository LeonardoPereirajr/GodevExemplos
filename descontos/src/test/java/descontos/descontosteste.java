package descontos;

import static org.junit.Assert.*;

import org.junit.Test;

public class descontosteste {

	@Test
	public void test() {
		double calculaInss = descontosFolha.descontoInss(2);
		assertEquals(300, 300);
	}

	@Test
	public void test2() {
		double calculaInss = descontosFolha.descontoInss(1);
		assertNotEquals(250, 350);
	}

	@Test
	public void test3() {
		double valeTransporte = descontosFolha.vt(2);
		assertEquals(300, 300);
	}

	@Test
	public void test4() {
		double valeTransporte = descontosFolha.vt(1);
		assertNotEquals(300, 250);
	}

}
