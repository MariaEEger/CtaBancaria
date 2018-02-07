package classesobjetosCta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Conta {
	private String titularDaConta;
	private int tipoConta;/* (1-conta poupan�a, 2-conta corrente) */
	private double saldo;
	private List<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	

	
	// Getters e Setters abaixo, respectivamente buscam e alteram atributos da
	// classe Conta//

	// M�todo que busca(get) a t�tular da conta
	public String getTitularDaConta() {
		return this.titularDaConta;// retorna a string itularDaConta quando o
									// m�todo getiTitularDaConta for usado
	}

	// M�todo que recebe a altera��o(set) do titularDaConta(atributo) da conta
	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;// recebe a altera��o da string
												// titularDaConta quando o
												// m�todo setTitularDaConta for
												// usado
	}

	// M�todo que busca(get) o tipo da conta
	public int getTipoConta() {
		return this.tipoConta;// retorna o int tipo quando o m�todo getTipo for usado
	}

	// M�todo que recebe a altera��o(set) do tipo da conta
	public void setTipoConta(int tipo) {
		this.tipoConta = tipoConta;// recebe a altera��o do int tipo da conta quando o
							// m�todo setTipo for usado
	}

	// M�todo que busca(get) o Saldo da conta
	public double getSaldo() {
		return this.saldo;// retorna o double Saldo quando o m�todo getSaldo for
							// usado
	}

	// M�todo que recebe a altera��o(set) do Saldo da conta
	public void setSaldo(double saldo) {
		this.saldo = saldo;// recebe a altera��o do double Saldo da conta quando
							// o m�todo setSaldo for usado
	}

	// Busca todos os carros vendidos
	public List<Movimentacao> getListaDeMovimentacao() {
		return this.listaDeMovimentacao;
	}

	// Busca todos os carros vendidos
	public void setListaDeMovimentacao(List<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	// Cria o objeto mvto na listaDeMovimentacao
	public void movimentacao(Movimentacao mvto) {
		listaDeMovimentacao.add(mvto);
	}

	// Construtor
	public Conta() {
		saldo = 0;
	}

}
