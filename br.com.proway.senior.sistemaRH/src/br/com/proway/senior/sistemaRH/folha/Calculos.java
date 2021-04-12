package br.com.proway.senior.sistemaRH.folha;

public class Calculos {
//Criacao de variaveis//

	static double salarioBruto = 3000.00;
	static double valeTransporte = 180.00;
	static double percentualInss = 0;
	static double descontoInss = 0;

//chamada do metodo main e chamada dos metodos de Vale transporte de de desconto de INSS//

	public static void main(String[] args) {
		descontoInss(percentualInss);
		vt(valeTransporte);
		System.out.println( " O salario liquido é de : R$ " + (salarioBruto-descontoInss-valeTransporte));
	}

//criacao do metodo que calcula o desconto de INSS//
	static double descontoInss(double percentualInss) {
		descontoInss = salarioBruto * 0.11;
		System.out.println("O valor do desconto de Inss sera : " + descontoInss);
		return descontoInss;

	}

//criacao do metodo que calcula o desconto de Vale transporte//
	static void vt(double valetransporte) {
		if ((0.06 * salarioBruto) >= 180) {
			System.out.println("O desconto de Vale Transporte sera de : R$ " + valeTransporte);
		} else
			System.out.println("O desconto de Vale Transporte sera de : R$ " + (0.06 * salarioBruto));
			
	}
}
