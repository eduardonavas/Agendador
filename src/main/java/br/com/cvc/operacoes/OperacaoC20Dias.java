package br.com.cvc.operacoes;


import br.com.cvc.interfaces.OperacaoC;

public class OperacaoC20Dias implements OperacaoC {

	private final int MINIMO = 20;
	private final int MAX = 30;
	private float taxaPorcentagem = (float) 6.9;
	
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
