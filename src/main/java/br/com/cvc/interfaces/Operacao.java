package br.com.cvc.interfaces;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;

public interface Operacao {
	
	public void calcularTaxa() throws ExceptionRegraDeNegocio;
}
