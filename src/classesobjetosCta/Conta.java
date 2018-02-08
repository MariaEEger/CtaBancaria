package classesobjetosCta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Conta {
	
	// Atributos da Conta
	private String titularDaConta;
	private int tipoConta;/* (1-conta poupanca, 2-conta corrente) */
	private double saldo;
	private List<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	
	// Métodos que alteram atributos da Conta
	// Busca o titular da conta
	public String getTitularDaConta() {
		return this.titularDaConta;
	}

	// Altera o titula da conta
	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	// Busca o tipo da conta
	public int getTipoConta() {
		return this.tipoConta;
	}

	// Altera o tipo da conta
	public void setTipoConta(int tipo) {
		this.tipoConta = tipoConta;
	}

	// Busca o saldo da conta
	public double getSaldo() {
		return this.saldo;
	}

	// Altera o Saldo da conta
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Busca todos os movimentos
	public List<Movimentacao> getListaDeMovimentacao() {
		return this.listaDeMovimentacao;
	}

	// Altera movimentos
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
