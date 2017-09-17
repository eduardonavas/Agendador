package br.com.cvc.operacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.interfaces.Operacao;
import br.com.cvc.model.Agendamento;


public class OperacaoB implements Operacao {

	private final int VALOR_TAXA = 12;
	private final String MESSAGE_EXCEPTION = "O valor de sua transacao foi identificada como operacao do tipo B mas para a operacao ser concluida a transferencia tem que ser ate 10 dias da data de agendamento.";
	private final char NOME_OPERACAO = 'B';
	private final int DIAS_MINIMO = 0;
	private final int DIAS_MAX = 10;
	private Agendamento agendamento;
	
	public OperacaoB(Agendamento agendamento){
		this.agendamento = agendamento;
	}
		
	private boolean agendamentoValidao(){
		LocalDate dataAgendamento = LocalDate.parse(agendamento.getDataAgendamento());
		LocalDate dataTransferencia = LocalDate.parse(agendamento.getDataTransferencia());
		long dias = ChronoUnit.DAYS.between(dataAgendamento , dataTransferencia);
		
		return dias >= DIAS_MINIMO && dias <= DIAS_MAX;
		
	}

	@Override
	public void calcularTaxa() throws ExceptionRegraDeNegocio {
		if(!agendamentoValidao()){
			ExceptionRegraDeNegocio ern = new ExceptionRegraDeNegocio();
			ern.setMessage(MESSAGE_EXCEPTION);
			throw ern;
		}
		
		double taxa = VALOR_TAXA;
		
		agendamento.setTaxa(taxa);
		agendamento.setOperacaoAplicada(NOME_OPERACAO);
		agendamento.setDebtoTotal(new BigDecimal(agendamento.getValor().doubleValue() + taxa));
	}

}
