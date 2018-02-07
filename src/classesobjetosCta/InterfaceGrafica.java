package classesobjetosCta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class InterfaceGrafica {

	// Objetos criados com a respectiva classe que ser� movimentada por ele
	Conta conta = new Conta();
	Movimentacao mvto = new Movimentacao();
	double sld = 0;

	public void exibirMenu() {

		// Estrutura de repetição para perguntar ao usu�rio qual a opnião de
		// menu
		JOptionPane.showMessageDialog(null,
				"*********************************\n"
						+ "       Bem-vindo ao banco     \n"
						+ "              Dona Maria!      \n"
						+ "Sua dívida é a nossa alegria!\n"
						+ "*********************************");
		String titular = JOptionPane
				.showInputDialog("Informe o nome do titular da conta: ");
		conta.setTitularDaConta(titular);
		int tipo = Integer.parseInt(JOptionPane
				.showInputDialog("Informe o nome do tipo da conta: \n"
						+ "1 - Conta Poupança\n" + "2 - Conta Corrente\n"));
		conta.setTipoConta(tipo);

		while (true) {
			int opcao = Integer.parseInt(JOptionPane
					.showInputDialog("Escolha uma opção : \n"
							+ "1 - Solicitar Informações de Depósito\n"
							+ "2 - Solicitar Informaçoes de Saque\n"
							+ "3 - Exibir Dados da Conta\n"
							+ "4 - Exibir Extrato Completo\n"
							+ "5 - Exibir Extrato de Depósitos\n"
							+ "6 - Exibir Extrato de Saques\n" + "7 - Sair"));

			switch (opcao) {
			case 1:
				solicitarInformacoesDeposito(conta);
				break;
			case 2:
				solicitarInformacoesSaque(conta);
				break;
			case 3:
				exibirDadosDaConta(conta);
				break;
			case 4:
				exibirExtratoCompleto(conta);
				break;
			case 5:
				exibirExtratoDeDepositos(conta);
				break;
			case 6:
				exibirExtratoDeSaques(conta);
				break;
			case 7:
				System.exit(0);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Opção Inexistente",
						"Erro", JOptionPane.OK_CANCEL_OPTION);
				break;
			}
		}
	}// Fim do m�todo exibirMenu

	// 1ª Opção do menu
	public void solicitarInformacoesDeposito(Conta conta) {

		JOptionPane.showMessageDialog(null, "DEPÓSITOS");

		System.out.println("A data do depósito : " + mvto.dataFormato());

		int tipo = 1;/* Movimentaçãoo do tipo 2 (1-saque, 2-deposito) */
		double valor = Double.parseDouble(JOptionPane
				.showInputDialog("Vamos desapegar de quanto nesse depósito?"));
		/* conta.depositar(valor); */

		// Criando objeto mvto
		Movimentacao mvto = new Movimentacao();

		// O valor � recebido na vari�vel sld
		sld = conta.getSaldo();
		// O novo saldo � a soma do valor mais o saldo original
		sld = valor + sld;
		// Setando o novo saldo no m�todo setSaldo que altera o atributo saldo
		// da classe Conta
		conta.setSaldo(sld);
		// Tipo de movimenta��o � setado no atributo tipo da classe Movimenta��o
		mvto.setTipo(tipo);
		// Tipo de movimenta��o � setado no atributo valor da classe
		// Movimenta��o
		mvto.setValor(valor);
		// Adicionar o objeto mvto ao objeto conta atrav�s do m�todo
		// movimentacao criado na classe Conta
		conta.movimentacao(mvto);

	}

	// 2ª Opção do menu
	public void solicitarInformacoesSaque(Conta conta) {
		double valor = conta.getSaldo();

		int tipo = 2;/* Movimenta��o do tipo 2 (1-saque, 2-deposito) */
		JOptionPane.showMessageDialog(null,
				"Seu saldo é de " + conta.getSaldo() + ".");
		valor = Double.parseDouble(JOptionPane
				.showInputDialog("Qual valor deseja sacar?"));

		// Valida��o do saque at� saldo -1.000 negativo
		/* CORRIGIR SAQUE COM -1000 */
		if ((conta.getSaldo() > -1000) && (conta.getSaldo() - valor < -1000)) {
			JOptionPane
					.showMessageDialog(null,
							"Mais que - $ 1.000 negativo não rola, cabou o limite queri.");
		} else {
			/* conta.sacar(valor); *//*
									 * Recebe a string valor e usa no m�todo
									 * sacar que altera o objeto conta
									 */
			Date data = new Date();/* Só cria a data se o saque for possível */
			System.out.println("A data do saque é " + mvto.dataFormato());

			// Criando objeto mvto para receber a manipulação dos atributos
			// que serão manipulados apenas se o saque for possível
			Movimentacao mvto = new Movimentacao();

			// O valor é recebido na variável sld
			sld = conta.getSaldo();			
			// O novo saldo é a soma do valor mais o saldo original
			sld = sld - valor;
			// Setando o novo saldo no m�todo setSaldo que altera o atributo
			// saldo
			// da classe Conta
			conta.setSaldo(sld);
			// Tipo de movimenta��o � setado no atributo tipo da classe
			// Movimenta��o
			mvto.setTipo(tipo);
			// Tipo de movimenta��o � setado no atributo valor da classe
			// Movimenta��o
			mvto.setValor(valor);
			// Adicionar o objeto mvto ao objeto conta atrav�s do m�todo
			// movimentacao criado na classe Conta
			conta.movimentacao(mvto);
		}
	}

	// 3ª Opção do menu
	public void exibirDadosDaConta(Conta conta) {
		JOptionPane.showMessageDialog(null,
				"Titular da conta: " + conta.getTitularDaConta() + "\n"
						+ "Saldo em conta: $" + conta.getSaldo());
		System.out.println("Titular da conta: " + conta.getTitularDaConta());
		System.out.println("Saldo em conta: $" + conta.getSaldo());
	}

	// 4ª Opção do menu
	public void exibirExtratoCompleto(Conta conta) {
		if (conta.getTitularDaConta() == "") {
			JOptionPane.showMessageDialog(null, "Errou a conta não existe.");
		} else {

			String extrato = "", tpMvto = "", msgTela = "", tpConta = "";
			for (Movimentacao mvto : conta.getListaDeMovimentacao()) {
				if (mvto.getTipo() == 1) {
					tpMvto = "Depósito";
				} else {
					tpMvto = "Saque";
				}
				if (conta.getTipoConta() == 1) {
					tpConta = "Conta Corrente";
				} else {
					tpConta = "Conta Poupança";
				}
				msgTela = "----------------------------------------------\n"
						+ "|             EXTRATO COMPLETO                |\n"
						+ "----------------------------------------------\n"
						+ "Titular: " + conta.getTitularDaConta() + "\n"
						+ "Tipo da Conta:" + tpConta;
				extrato += "Tipo da movimentação: " + tpMvto + "\n" + "Valor: "
						+ mvto.getValor() + "\n" + "Data: "
						+ mvto.dataFormato() + "\n";

			}
			JOptionPane.showMessageDialog(null, msgTela + "\n" + extrato,
					"Extrato \n", JOptionPane.OK_CANCEL_OPTION);
		}
	}

	// 5ª Opção do menu
	public void exibirExtratoDeDepositos(Conta conta) {
		if (conta.getListaDeMovimentacao() == null) {
			JOptionPane.showMessageDialog(null,
					"Errou a conta não tem depósitos.");
		} else {
			String extrato = "", tpMvto = "", msgTela = "", tpConta = "";
			for (Movimentacao mvto : conta.getListaDeMovimentacao()) {
				if (mvto.getTipo() == 1) {
					tpMvto = "Depósito";
					if (conta.getTipoConta() == 1) {
						tpConta = "Conta Corrente";
					} else {
						tpConta = "Conta Poupança";
					}
					msgTela = "----------------------------------------------\n"
							+ "|          EXTRATO DE DEPÓSITOS              |\n"
							+ "----------------------------------------------\n"
							+ "Titular: "
							+ conta.getTitularDaConta()
							+ "\n"
							+ "Tipo da Conta:" + tpConta;
					extrato += "Tipo da movimentação: " + tpMvto + "\n"
							+ "Valor: " + mvto.getValor() + "\n" + "Data: "
							+ mvto.dataFormato() + "\n";

				}
			}
			JOptionPane.showMessageDialog(null, msgTela + "\n" + extrato,
					"Extrato \n", JOptionPane.OK_CANCEL_OPTION);
		}
	}

	// 6� Op��o do menu
	public void exibirExtratoDeSaques(Conta conta) {
		if (conta.getListaDeMovimentacao() == null) {
			JOptionPane
					.showMessageDialog(null, "Errou a conta não tem saques.");
		} else {

			String extrato = "", tpMvto = "", msgTela = "", tpConta = "";
			for (Movimentacao mvto : conta.getListaDeMovimentacao()) {
				if (mvto.getTipo() == 2) {
					tpMvto = "Saque";

					if (conta.getTipoConta() == 1) {
						tpConta = "Conta Corrente";
					} else {
						tpConta = "Conta Poupança";
					}
					msgTela = "----------------------------------------------\n"
							+ "|           EXTRATO DE SAQUES                |\n"
							+ "----------------------------------------------\n"
							+ "Titular: "
							+ conta.getTitularDaConta()
							+ "\n"
							+ "Tipo da Conta:" + tpConta;
					extrato += "Tipo da movimentação: " + tpMvto + "\n"
							+ "Valor: " + mvto.getValor() + "\n" + "Data: "
							+ mvto.dataFormato() + "\n";

				}
			}
			JOptionPane.showMessageDialog(null, msgTela + "\n" + extrato,
					"Extrato \n", JOptionPane.OK_CANCEL_OPTION);
		}
	}
}