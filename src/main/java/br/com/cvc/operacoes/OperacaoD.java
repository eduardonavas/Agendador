package br.com.cvc.operacoes;

import java.math.RoundingMode;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.verificacoes.EnumDecisao;
import br.com.cvc.verificacoes.EnumOperacaoes;


public class OperacaoD {

	
	private final String MESSAGE_EXCEPTION = "Nao existe operacao aplicavel para o valor: ";
	private final int ARREDEONDAMENTO = 2;
	
	public void operacaoD(Agendamento agendamento) throws ExceptionRegraDeNegocio{
				
		EnumOperacaoes enumOperacoes = null;
		for(EnumDecisao enumDecisoes : EnumDecisao.values()){
			if((enumOperacoes = enumDecisoes.decideOperacao(agendamento.getValor().doubleValue())) != null){
				enumOperacoes.operacao(agendamento).executaOperacao();
				break;
			}
		}
		
		if (enumOperacoes == null) {
			ExceptionRegraDeNegocio ern = new ExceptionRegraDeNegocio();
			ern.setMessage(MESSAGE_EXCEPTION + agendamento.getValor());
			throw ern;
		}
		
		agendamento.setDebtoTotal(agendamento.getValor().add(agendamento.getTaxa()).setScale(ARREDEONDAMENTO, RoundingMode.HALF_EVEN));
	}
}
