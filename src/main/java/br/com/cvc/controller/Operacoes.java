package br.com.cvc.controller;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.interfaces.Operacao;

public class Operacoes {

	private Operacao operacao;
	
	public Operacoes(Operacao operacao) {

		this.operacao = operacao;
	}
	
	public void executaOperacao() throws ExceptionRegraDeNegocio{
		
			operacao.calcularTaxa();
		
	}
}
