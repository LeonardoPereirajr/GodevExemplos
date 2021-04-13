package descontos;

public class outrosDescontos {
	static int idEvento = 505;
	static String descricaoEvento = "Horas Extras 50%";
	static String tipoEvento = "Adicionais";
	static String tipoReferenciaEvento = "Horas";
	static double valorReferenciaEvento = 15.00;
	static double valorSalarioInicial;
	static double valorSalarioFinal;
	static double valorDiferencaSalario;
	static double valorInsalubridade = 220.00;
	static double valorMinimo = 1100.00;
	static int colabId = 101;
	static String nomeColab = "Maria";
	static double quantidadeHorasTrabalhadas = 220;
	static double valorHoraColab = 12.81;
	static boolean possuiInsalubridade = true;
	static double quantidadeHorasExtrasColab = 15;
	static double percentualInsalubridadeColab = 20;
	static double quantidadeHorasFaltas = 20;
	static double valorMensalidadePlanoSaude = 100.00;
	static double valorCoparticipacaoPlano = 236.25;
	static double valorBonificacaoColab = 250.00;

	/**
	 * Criar evento para folha
	 * 
	 * Realiza o cadastro de um evento para a folha de pagamento e retorna uma
	 * mensagem de sucesso.
	 * 
	 * @param idEvento              int número de identificação do evento
	 * @param descricaoEvento       String descrição/nome do evento
	 * @param tipoEvento            String define o tipo de evento (demonstrativo,
	 *                              descontos, proventos ou adicionais)
	 * @param tipoReferenciaEvento  String define o tipo da referência (horas,
	 *                              quantidade, valor ou percentual)
	 * @param valorReferenciaEvento double define o valor da referência
	 * @return mensagem de sucesso
	 */
	public static String cadastroEvento(int idEvento, String descricaoEvento, String tipoEvento,
			String tipoReferenciaEvento, double valorReferenciaEvento) {
		int setIdEvento = idEvento;
		String setDescricaoEvento = descricaoEvento;
		String setTipoEvento = tipoEvento;
		String setTipoReferenciaEvento = tipoReferenciaEvento;
		double setValorReferenciaEvento = valorReferenciaEvento;
		String mensagem = "Evento cadastrado com sucesso.";
		return mensagem;

	}

	// Retorna o valor da folha total do colaborador
	// Incluir HE no IR
	public static double calculaSalario(int colabId) {
		double horaComInsalubridade = calculaHoraComInsalubridade(valorHoraColab, quantidadeHorasTrabalhadas,
				percentualInsalubridadeColab);
		double valorSalarioBruto = calculaHorasTrabalhadas(quantidadeHorasTrabalhadas, horaComInsalubridade);
		valorSalarioBruto += valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5);
		valorSalarioBruto += adicionaBonificacao(valorBonificacaoColab);
		double salarioDescontos = valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas)
				+ descontaPlanoSaude(valorMensalidadePlanoSaude, valorCoparticipacaoPlano)
				+ calculaImpostoRenda(valorSalarioBruto) + descontoInss(valorSalarioBruto);
		double salarioFinal = valorSalarioBruto - salarioDescontos;
		return salarioFinal;
	}

	// Método para "imprimir" a folha do colaborador
	public static void imprimeFolha(int colabId) {
		System.out.println("Cadastro: " + colabId);
		System.out.println("Nome: " + nomeColab);
		System.out.println();
		double horaComInsalubridade = calculaHoraComInsalubridade(valorHoraColab, quantidadeHorasTrabalhadas,
				percentualInsalubridadeColab);
		double valorSalarioBruto = calculaHorasTrabalhadas(quantidadeHorasTrabalhadas, horaComInsalubridade)
				+ valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5)
				+ adicionaBonificacao(valorBonificacaoColab);
		System.out.println("Valor bruto: " + valorSalarioBruto);
		System.out.println("Valor horas extras (+): R$ "
				+ valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5));
		System.out.println("Valor bonificações (+): R$ " + adicionaBonificacao(valorBonificacaoColab));
		System.out.println();
		double salarioDescontos = valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas)
				+ descontaPlanoSaude(valorMensalidadePlanoSaude, valorCoparticipacaoPlano)
				+ calculaImpostoRenda(valorSalarioInicial) + descontoInss(valorSalarioBruto);
		System.out
				.println("Valor horas faltas (-): R$ " + valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas));
		System.out.println("Valor plano de saúde (-): R$ "
				+ descontaPlanoSaude(valorMensalidadePlanoSaude, valorCoparticipacaoPlano));
		System.out.println("Valor INSS (-): R$ " + descontoInss(valorSalarioBruto));
		System.out.println("Valor IR (-): R$ " + calculaImpostoRenda(valorSalarioBruto));
		System.out.println("Valor total descontos (-): R$ " + salarioDescontos);
		System.out.println();
		double salarioFinal = valorSalarioBruto - salarioDescontos;
		System.out.println("Valor líquido: R$ " + salarioFinal);
	}

	// Calcula insalubridade
	public static double valorInsalubridade(double percentual) {
		if (percentual == 10) {
			return valorInsalubridade = valorMinimo * 0.10;
		} else if (percentual == 20) {
			return valorInsalubridade = valorMinimo * 0.20;
		} else if (percentual == 40) {
			return valorInsalubridade = valorMinimo * 0.40;
		} else if (percentual == 0) {
			return valorInsalubridade = 0;
		} else {
			System.out.println("Informe um valor válido (10, 20 ou 40%)");
		}
		return valorInsalubridade;
	}

	// Calcula salário "bruto"
	public static double calculaHorasTrabalhadas(double quantidadeHorasTrabalhadas, double valorHoraComInsalubridade) {
		double valorSalarioInicial = quantidadeHorasTrabalhadas * valorHoraComInsalubridade;
		return valorSalarioInicial;
	}

	// Calcula o valor "bruto" do salário (quantidades horas trabalhadas * valor
	// hora) MAIS valor de insalubridade
	public static double calculaHoraComInsalubridade(double valorHora, double quantidadeHorasTrabalhadas,
			double percentualInsalubridade) {
		double valorHoraComInsalubridade = 0;
		double valorInsalubridade = valorInsalubridade(percentualInsalubridade);
		if (valorInsalubridade > 0) {
			valorHoraComInsalubridade = valorHora + (valorInsalubridade / quantidadeHorasTrabalhadas);
		} else if (valorInsalubridade == 0) {
			valorSalarioInicial = valorHora * quantidadeHorasTrabalhadas;
		}
		return valorHoraComInsalubridade;
	}

	// Retorna a diferença a ser paga de hora extra, conforme percentual "fator"
	public static double valorHorasExtras(double valorHora, double quantidadeHrsExtras, double fator) {
		double valorHrsExtras = quantidadeHrsExtras * valorHora;
		valorDiferencaSalario = valorHrsExtras + (valorHrsExtras * fator);
		return valorDiferencaSalario;
	}

	// Retorna a diferença a ser descontada de horas faltas
	public static double valorHorasFaltas(double valorHora, double quantidadeHrsFaltas) {
		double valorHorasFaltas = quantidadeHrsFaltas * valorHora;
		valorDiferencaSalario = valorHorasFaltas;
		return valorDiferencaSalario;
	}

	// Retorna o valor a ser descontado de plano de saúde: mensalidade +
	// coparticipação
	public static double descontaPlanoSaude(double valorMensalidade, double valorCoparticipacao) {
		double totalDescontoPlanoSaude = valorMensalidade + valorCoparticipacao;
		return totalDescontoPlanoSaude;
	}

	static double calculaImpostoRenda(double valorSalarioInicial) {
		double resultado;

		if (valorSalarioInicial <= 1903.98) {
			resultado = 0;
		} else if (valorSalarioInicial >= 1903.98 && valorSalarioInicial <= 2826.65) {
			resultado = (valorSalarioInicial * 0.075) - 142.80;
		} else if (valorSalarioInicial >= 2826.66 && valorSalarioInicial <= 3751.05) {
			resultado = (valorSalarioInicial * 0.15) - 354.80;
		} else if (valorSalarioInicial >= 3751.06 && valorSalarioInicial <= 4664.68) {
			resultado = (valorSalarioInicial * 0.225) - 636.13;
		} else {
			resultado = (valorSalarioInicial * 0.275) - 869.36;
		}

		return resultado;
	}

	// Método bonificação
	static double adicionaBonificacao(double valor) {
		return valor;
	}

	/**
	 *
	 * Metodo INSS
	 * 
	 * @param valorSalarioBruto
	 * @return calculaInss
	 */
	static double descontoInss(double valorSalarioBruto) {
		double calculaInss = valorSalarioBruto * 0.11;
		return calculaInss;

	}

	public static void main(String[] args) {

		// Chamando os métodos
		// System.out.println("R$ " + calculaHoraComInsalubridade(9.50, 220, 40));
		// System.out.println("R$ " + valorHorasExtras(9.50, 15, 0.5));
		System.out.println("R$ " + calculaSalario(101));
		imprimeFolha(101);
		// System.out.println(cadastroEvento(idEvento, descricaoEvento, tipoEvento,
		// tipoReferenciaEvento, valorReferenciaEvento));
	}

}
