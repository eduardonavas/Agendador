package br.com.cvc.operacoes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.interfaces.Operacao;
import br.com.cvc.model.Agendamento;


public class OperacaoB implements Operacao {

	private final int VALOR_TAXA = 12;
	private final String MESSAGE_EXCEPTION = "ERRO: Agendamentos com valores entre 1001 e 2000 so sao permitidos quando a data de agendamento for de ate 10 dias da data de solicitacao";
	private final char NOME_OPERACAO = 'B';
	private final int DIAS_MINIMO = 0;
	private final int DIAS_MAX = 10;
	private final int ARREDEONDAMENTO = 2;
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
		
		agendamento.setTaxa(new BigDecimal(taxa).setScale(ARREDEONDAMENTO, RoundingMode.HALF_EVEN));
		agendamento.setOperacaoAplicada(NOME_OPERACAO);
	}

}
