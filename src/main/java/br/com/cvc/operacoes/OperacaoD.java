package br.com.cvc.operacoes;

import java.math.RoundingMode;


import br.com.cvc.controller.Operacoes;
import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;

public class OperacaoD {

	private final int VALOR_OPERACA_A_MAX = 1000;
	private final int ZERO = 0;
	private final String MESSAGE_EXCEPTION = "Nao existe operacao aplicavel para o valor: ";
	private final int VALOR_OPERACAO_B_MIN = 1001;
	private final int VALOR_OPERACAO_B_MAX = 2000;
	private final int ARREDEONDAMENTO = 2;
	
	public void operacaoD(Agendamento agendamento) throws ExceptionRegraDeNegocio{
		
		double valorTransacao = agendamento.getValor().doubleValue();
		Operacoes operacoes = null;
		
		//Verifica se valor é para a taxação do tipo A
		if(valorTransacao > ZERO && valorTransacao <= VALOR_OPERACA_A_MAX){
			operacoes = new Operacoes(new OperacaoA(agendamento));
			operacoes.executaOperacao();
		}
		//Verifica se valor é para a taxação do tipo B
		else if(valorTransacao >= VALOR_OPERACAO_B_MIN && valorTransacao <= VALOR_OPERACAO_B_MAX){
			operacoes = new Operacoes(new OperacaoB(agendamento));
			operacoes.executaOperacao();
		}
		//Verifica se valor é para a taxação do tipo C
		else if(valorTransacao > VALOR_OPERACAO_B_MAX){
			operacoes = new Operacoes(new OperacaoC(agendamento));
			operacoes.executaOperacao();
		}
		else{
			ExceptionRegraDeNegocio ern = new ExceptionRegraDeNegocio();
			ern.setMessage(MESSAGE_EXCEPTION + agendamento.getValor());
			throw ern;
		}
		
		agendamento.setDebtoTotal(agendamento.getValor().add(agendamento.getTaxa()).setScale(ARREDEONDAMENTO, RoundingMode.HALF_EVEN));
	}
}
