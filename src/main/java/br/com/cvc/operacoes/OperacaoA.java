package br.com.cvc.operacoes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.interfaces.Operacao;
import br.com.cvc.model.Agendamento;

public class OperacaoA implements Operacao{
	
	private final String MESSAGE_EXCEPTION = "ERRO: Agendamentos com valores de ate 1000 so sao permitidos quando a data do agendamento for a mesma da data de solicitacao";
	private final float VALOR_COBRANCA = 3;
	private final float PORCENTAGEM = (float) 0.03;
	private final int ARREDEONDAMENTO = 2;
	private final int RETORNO_VALIDO = 0;
	private final char NOME_OPERACAO = 'A';
	private Agendamento agendamento;
	
	public OperacaoA(Agendamento agendamento){
		this.agendamento = agendamento;
	}
		
	private boolean agendamentoValidao(){
		
		LocalDate dataAgendamento = LocalDate.parse(agendamento.getDataAgendamento());
		LocalDate dataTransferencia = LocalDate.parse(agendamento.getDataTransferencia());
		long dias = ChronoUnit.DAYS.between(dataAgendamento , dataTransferencia);
		
		return dias == RETORNO_VALIDO;
		
	}

	@Override
	public void calcularTaxa() throws ExceptionRegraDeNegocio {
		
		if(!agendamentoValidao()){
			ExceptionRegraDeNegocio ern = new ExceptionRegraDeNegocio();
			ern.setMessage(MESSAGE_EXCEPTION);
			throw ern;
		}
		
		double taxa = new BigDecimal((agendamento.getValor().doubleValue()*PORCENTAGEM) + VALOR_COBRANCA).doubleValue();
		
		agendamento.setTaxa(new BigDecimal(taxa).setScale(ARREDEONDAMENTO, RoundingMode.HALF_EVEN));
		agendamento.setOperacaoAplicada(NOME_OPERACAO);
		
	}
}
