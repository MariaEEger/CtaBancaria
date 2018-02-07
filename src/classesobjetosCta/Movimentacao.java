package classesobjetosCta;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Movimentacao {

	// Atributos da Classe Movimentacao
	/*private String data; String data foi substitu�da pelo componente data do tipo Date*/	
	private int tipo;/*(1-saque, 2-deposito)*/
	private double valor;
	private Date data = new Date();
	
	// Getters e Setters abaixo, respectivamente buscam e alteram atributos da
	// classe Movimentacao//

	// M�todo que busca(get) o tipo de movimenta��o
	public int getTipo() {
		return this.tipo;// retorna o tipo de movimenta��o quando o
							// m�todo getTipo for usado
	}

	// M�todo que recebe a altera��o(set) do Tipo(atributo) da conta
	public void setTipo(int tipo) {
		this.tipo = tipo;// recebe a altera��o do double tipo da movimenta��o
							// quando o
							// m�todo setTipo for usado
	}

	// M�todo que busca(get) o valor da movimenta��o
	public double getValor() {
		return this.valor;// retorna o valor da movimenta��o quando o
							// m�todo getValor for usado
	}

	// M�todo que recebe a altera��o(set) do valor(atributo) da conta
	public void setValor(double valor) {
		this.valor = valor;// recebe a altera��o do double valor da movimenta��o
							// quando o
							// m�todo setValor for usado
	}
	public String dataFormato(){
		SimpleDateFormat dataFormato =  new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return dataFormato.format(data);
	}

}
