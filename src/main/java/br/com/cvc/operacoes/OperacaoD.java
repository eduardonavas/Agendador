package br.com.cvc.operacoes;

import br.com.cvc.controller.Operarcoes;
import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;

public class OperacaoD {

	private final int VALOR_OPERACA_A_MAX = 1000;
	private final int ZERO = 0;
	
	private final int VALOR_OPERACAO_B_MIN = 1001;
	private final int VALOR_OPERACAO_B_MAX = 2000;
	
	public void operacaoD(Agendamento agendamento) throws ExceptionRegraDeNegocio{
		
		double valorTransacao = agendamento.getValor().doubleValue();
		Operarcoes operacoes = null;
		if(valorTransacao > ZERO && valorTransacao <= VALOR_OPERACA_A_MAX){
			operacoes = new Operarcoes(new OperacaoA(agendamento));
			operacoes.executaOperacao();
		}else if(valorTransacao >= VALOR_OPERACAO_B_MIN && valorTransacao <= VALOR_OPERACAO_B_MAX){
			operacoes = new Operarcoes(new OperacaoB(agendamento));
			operacoes.executaOperacao();
		}else if(valorTransacao > VALOR_OPERACAO_B_MAX){
			
		}
	}
}
