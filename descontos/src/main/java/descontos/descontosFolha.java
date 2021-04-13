package descontos;

public class descontosFolha {
	static double salarioBruto = 3000.00;
	static double valeTransporte = 180.00;
	static double percentualInss = 0.11;
	static double calculaInss = 0;

	public static void main(String[] args) {

		/**
		 * Chamada do metodo Vale transporte de de desconto de INSS
		 */
		descontoInss(percentualInss);
		vt(valeTransporte);
		System.out.println("O salario liquido é de : R$ " + (salarioBruto - calculaInss - valeTransporte));
	}

	/*
	 * criacao do metodo que calcula o desconto de INSS
	 */

	static double descontoInss(double percentualInss) {
		calculaInss = salarioBruto * percentualInss;
		System.out.println("O valor do desconto de Inss sera : R$ " + calculaInss);
		return calculaInss;

	}

	/*
	 * criacao do metodo que calcula o desconto de Vale transporte
	 */
	static double vt(double valetransporte) {
		if ((0.06 * salarioBruto) >= 180) {
			System.out.println("O desconto de Vale Transporte sera de : R$ " + valeTransporte);
		} else
			System.out.println("O desconto de Vale Transporte sera de : R$ " + (0.06 * salarioBruto));
		return valetransporte;

	}

}
