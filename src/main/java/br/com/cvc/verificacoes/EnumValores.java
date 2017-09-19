package br.com.cvc.verificacoes;

public enum EnumValores {

	OPERACAO_A_MIN(0), OPERACAO_A_MAX(1000), OPERACAO_B_MIN(1001), OPERACAO_B_MAX(2000);
	
	private int valor;
	
	private EnumValores(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}
}
