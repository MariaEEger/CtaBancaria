package classesobjetosCta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class InterfaceGrafica {

	
	Conta conta = new Conta();
	Movimentacao mvto = new Movimentacao();
	double sld = 0;

	public void exibirMenu() {

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
						+ "1 - Conta Poupanca\n" + "2 - Conta Corrente\n"));
		conta.setTipoConta(tipo);

		// MENU
		while (true) {
			int opcao = Integer.parseInt(JOptionPane
					.showInputDialog("Escolha uma opcao : \n"
							+ "1 - Depositar\n"
							+ "2 - Sacar\n"
							+ "3 - Dados da Conta\n"
							+ "4 - Extrato Completo\n"
							+ "5 - Extrato de Depositos\n"
							+ "6 - Extrato de Saques\n" + "7 - Sair"));

			switch (opcao) {
			case 1:
				depositar(conta);
				break;
			case 2:
				sacar(conta);
				break;
			case 3:
				dadosDaConta(conta);
				break;
			case 4:
				extratoCompleto(conta);
				break;
			case 5:
				extratoDeDepositos(conta);
				break;
			case 6:
				extratoDeSaques(conta);
				break;
			case 7:
				System.exit(0);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Opcao Inexistente",
						"Erro", JOptionPane.OK_CANCEL_OPTION);
				break;
			}
		}
	}// FIM MENU

	// 1- Depositar
	public void depositar(Conta conta) {
		JOptionPane.showMessageDialog(null, "DEPOSITOS");
		System.out.println("A data do deposito : " + mvto.dataFormato());

		int tipo = 1;/* Depósito */
		double valor = Double.parseDouble(JOptionPane
				.showInputDialog("Vamos desapegar de quanto nesse deposito?"));
		

		// Gerando deposito na conta
		Movimentacao mvto = new Movimentacao();
		sld = conta.getSaldo();
		sld = valor + sld;		
		conta.setSaldo(sld);		
		mvto.setTipo(tipo);		
		mvto.setValor(valor);
		//conta recebe depósito
		conta.movimentacao(mvto);

	}

	// 2- Sacar
	public void sacar(Conta conta) {
		double valor = conta.getSaldo();

		int tipo = 2;/* Saque */
		JOptionPane.showMessageDialog(null,
				"Seu saldo é de " + conta.getSaldo() + ".");
		valor = Double.parseDouble(JOptionPane
				.showInputDialog("Qual valor deseja sacar?"));

		// Validando limite da conta
		if ((conta.getSaldo() > -1000) && (conta.getSaldo() - valor < -1000)) {
			JOptionPane
					.showMessageDialog(null,
							"Mais que - $ 1.000 negativo nãoo rola, cabou o limite queri.");
		} else {
			
			Date data = new Date();
			System.out.println("A data do saque é " + mvto.dataFormato());
			
			// Gerando saque na conta
			Movimentacao mvto = new Movimentacao();
			sld = conta.getSaldo();
			sld = sld - valor;
			conta.setSaldo(sld);
			mvto.setTipo(tipo);
			mvto.setValor(valor);
			//conta recebe saque
			conta.movimentacao(mvto);
		}
	}

	// 3- Dados da Conta
	public void dadosDaConta(Conta conta) {
		JOptionPane.showMessageDialog(null,
				"Titular da conta: " + conta.getTitularDaConta() + "\n"
						+ "Saldo em conta: $" + conta.getSaldo());
		System.out.println("Titular da conta: " + conta.getTitularDaConta());
		System.out.println("Saldo em conta: $" + conta.getSaldo());
	}

	// 4- Extrato Completo
	public void extratoCompleto(Conta conta) {
		if (conta.getTitularDaConta() == "") {
			JOptionPane.showMessageDialog(null, "Errou a conta não existe.");
		} else {

			//Imprime todos os movimentos
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
				extrato += "Tipo da movimentaçãoo: " + tpMvto + "\n" + "Valor: "
						+ mvto.getValor() + "\n" + "Data: "
						+ mvto.dataFormato() + "\n";

			}
			JOptionPane.showMessageDialog(null, msgTela + "\n" + extrato,
					"Extrato \n", JOptionPane.OK_CANCEL_OPTION);
		}
	}

	// 5- Extrato de Depósitos
	public void extratoDeDepositos(Conta conta) {
		if (conta.getListaDeMovimentacao() == null) {
			JOptionPane.showMessageDialog(null,
					"Errou a conta não tem depósitos.");
		} else {
			
			// Imprime apenas depósitos
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
					extrato += "Tipo da movimentaçãoo: " + tpMvto + "\n"
							+ "Valor: " + mvto.getValor() + "\n" + "Data: "
							+ mvto.dataFormato() + "\n";

				}
			}
			JOptionPane.showMessageDialog(null, msgTela + "\n" + extrato,
					"Extrato \n", JOptionPane.OK_CANCEL_OPTION);
		}
	}

	// 6- Extrato de Saques
	public void extratoDeSaques(Conta conta) {
		if (conta.getListaDeMovimentacao() == null) {
			JOptionPane
					.showMessageDialog(null, "Errou a conta nãoo tem saques.");
		} else {
			//Imprime apenas saques
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
					extrato += "Tipo da movimentaçãoo: " + tpMvto + "\n"
							+ "Valor: " + mvto.getValor() + "\n" + "Data: "
							+ mvto.dataFormato() + "\n";

				}
			}
			JOptionPane.showMessageDialog(null, msgTela + "\n" + extrato,
					"Extrato \n", JOptionPane.OK_CANCEL_OPTION);
		}
	}
}