package br.com.cvc.verificacoes;


import br.com.cvc.interfaces.OperacaoC;

public class OperacaoC30Dias implements OperacaoC {

	private final int MINIMO = 30;
	private final int MAX = 40;
	private float taxaPorcentagem = (float) 4.7;
	
	public float getTaxa() {
		return taxaPorcentagem / 100;
	}

	@Override
	public boolean validarDias(long dias) {
		
		if(dias > MINIMO && dias <= MAX){
			
			return true;
		}
		
		return false;
	}
}
