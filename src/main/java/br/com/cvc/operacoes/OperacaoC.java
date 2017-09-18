package br.com.cvc.operacoes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


import br.com.cvc.controller.OperaracoesC;
import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.interfaces.Operacao;
import br.com.cvc.model.Agendamento;
import br.com.cvc.verificacoes.OperacaoC10Dias;
import br.com.cvc.verificacoes.OperacaoC20Dias;
import br.com.cvc.verificacoes.OperacaoC30Dias;
import br.com.cvc.verificacoes.OperacaoC40Dias;


public class OperacaoC implements Operacao {

	
	private final String MESSAGE_EXCEPTION = "ERRO: Agendamentos com valores acima de 2000 so sao permitidos quando a data do agendamento for superior a 10 dias da data de solicitacao";
	private final char NOME_OPERACAO = 'C';
	private final int ARREDEONDAMENTO = 2;
	private double taxa;
	private Agendamento agendamento;
	
	public OperacaoC(Agendamento agendamento){
		this.agendamento = agendamento;
	}
		
	private boolean agendamentoValidao(){
		LocalDate dataAgendamento = LocalDate.parse(agendamento.getDataAgendamento());
		LocalDate dataTransferencia = LocalDate.parse(agendamento.getDataTransferencia());
		long dias = ChronoUnit.DAYS.between(dataAgendamento , dataTransferencia);
		
		ArrayList<OperaracoesC> operacoesC = new ArrayList<>();
		
		operacoesC.add(new OperaracoesC(new OperacaoC10Dias()));
		operacoesC.add(new OperaracoesC(new OperacaoC20Dias()));
		operacoesC.add(new OperaracoesC(new OperacaoC30Dias()));
		operacoesC.add(new OperaracoesC(new OperacaoC40Dias()));
		
		for(OperaracoesC opC : operacoesC){
			if(opC.executaOperacao(dias)){
				taxa =  new BigDecimal(agendamento.getValor().doubleValue() * opC.getTaxa()).doubleValue();
				return true;
			}
		}
		
		
		return false;
		
	}

	@Override
	public void calcularTaxa() throws ExceptionRegraDeNegocio {
		if(!agendamentoValidao()){
			ExceptionRegraDeNegocio ern = new ExceptionRegraDeNegocio();
			ern.setMessage(MESSAGE_EXCEPTION);
			throw ern;
		}		
		agendamento.setTaxa(new BigDecimal(taxa).setScale(ARREDEONDAMENTO, RoundingMode.HALF_EVEN));
		agendamento.setOperacaoAplicada(NOME_OPERACAO);
	}

}
