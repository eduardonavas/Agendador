package br.com.cvc.controller;

import br.com.cvc.interfaces.OperacaoC;

public class OperaracoesC {

	private OperacaoC operacao;
	
	public OperaracoesC(OperacaoC operacao) {

		this.operacao = operacao;
	}
	
	public float getTaxa(){
		
		return operacao.getTaxa();
	}
	
	public boolean executaOperacao(long dias) {
		
			return operacao.validarDias(dias);
		
	}
}
