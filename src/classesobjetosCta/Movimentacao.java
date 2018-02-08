package classesobjetosCta;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Movimentacao {

	// Atributos da Movimentacao		
	private int tipo;/*(1-deposito, 2-saque)*/
	private double valor;
	private Date data = new Date();
	
	// Métodos que alteram atributos da Movimentacao
	// Busca o tipo
	public int getTipo() {
		return this.tipo;
	}

	// Altera o tipo do mvto
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	// Busca o valor do mvto
	public double getValor() {
		return this.valor;
	}

	// Altera o valor do mvto
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	// Formata Data do mvto
	public String dataFormato(){
		SimpleDateFormat dataFormato =  new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return dataFormato.format(data);
	}

}
