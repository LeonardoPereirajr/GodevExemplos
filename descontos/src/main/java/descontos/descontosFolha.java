package descontos;

/**
 * 
 * @author SENIOR Declaração de variaveis
 */
public class descontosFolha {
	static double valorSalarioBruto = 3000.00;
	static double valeTransporte = 180.00;
	static double percentualInss = 0.11;
	static double calculaInss = 0;

	public static void main(String[] args) {

		/**
		 * Chamada do metodo Vale transporte de de desconto de INSS
		 */
		descontoInss(percentualInss, valorSalarioBruto);
		vt(valeTransporte, valorSalarioBruto);
		System.out.println("O salario liquido é de : R$ " + (valorSalarioBruto - calculaInss - valeTransporte));
	}

	/**
	 * Chamada do metodo que calcula o desconto de INSS verificando o salario Bruto
	 * aplicando o percentual de 0.11%
	 * 
	 * @param percentualInss
	 * @return calculaInss
	 */
	static double descontoInss(double percentualInss, double valorSalarioBruto) {
		double calculaInss = valorSalarioBruto * percentualInss;
		System.out.println("O valor do desconto de Inss sera : R$ " + calculaInss);
		return calculaInss;

	}

	/**
	 * Chamada do metodo de Vale transporte que calcula o desconto, se o percentual
	 * aplicado de 0.06% for maior que R$ 180,00 o desconto será este, se for menor
	 * retorna este valor calculado.
	 * 
	 * @param valetransporte
	 * @return valetransporte
	 */
	static double vt(double valeTransporte, double valorSalarioBruto) {
		if ((0.06 * valorSalarioBruto) >= 180) {
			System.out.println("O desconto de Vale Transporte sera de : R$ " + valeTransporte);
		} else
			System.out.println("O desconto de Vale Transporte sera de : R$ " + (0.06 * valorSalarioBruto));
		return valeTransporte;

	}

}
