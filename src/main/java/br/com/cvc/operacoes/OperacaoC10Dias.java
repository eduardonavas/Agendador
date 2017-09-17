package br.com.cvc.operacoes;

import br.com.cvc.interfaces.OperacaoC;

public class OperacaoC10Dias implements OperacaoC {

	private final int MINIMO = 10;
	private final int MAX = 20;
	private float taxaPorcentagem = (float) 8.2;
	
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
