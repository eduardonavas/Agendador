package br.com.cvc.verificacoes;


import br.com.cvc.interfaces.OperacaoC;

public class OperacaoC40Dias implements OperacaoC {

	private final int MINIMO = 40;
	private float taxaPorcentagem = (float) 1.7;
	
	public float getTaxa() {
		return taxaPorcentagem / 100;
	}

	@Override
	public boolean validarDias(long dias) {
		
		if(dias > MINIMO){
			
			return true;
		}
		
		return false;
	}
}
