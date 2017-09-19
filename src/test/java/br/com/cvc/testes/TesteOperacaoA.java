package br.com.cvc.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoA;

public class TesteOperacaoA {

	@Test
	public void testeAgendamentoParaMesmoDia() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().format(formatter));
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(33, ag.getTaxa().doubleValue(),0);
		
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeAgendamentoAcimade1Dia() throws Exception{
		
		int dias = 3;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(10));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
	}
}
