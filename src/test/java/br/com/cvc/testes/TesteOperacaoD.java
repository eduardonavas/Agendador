package br.com.cvc.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoD;

public class TesteOperacaoD {

	
	@Test
	public void testeOperacaoA() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferecia("2017-09-17");
		ag.setValor(new BigDecimal(10));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(3.3, ag.getTaxa(),0);
		Assert.assertEquals(13.3, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('A', ag.getOperacaoAplicada(),0);
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeExceptonOperacaoA() throws ExceptionRegraDeNegocio{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferecia("2017-09-18");
		ag.setValor(new BigDecimal(10));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
	}
	
	
	@Test
	public void testeOperacaoB() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferecia("2017-09-17");
		ag.setValor(new BigDecimal(1001));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(12, ag.getTaxa(),0);
		Assert.assertEquals(1013, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('B', ag.getOperacaoAplicada(),0);
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeExceptonOperacaoB() throws ExceptionRegraDeNegocio{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferecia("2017-09-29");
		ag.setValor(new BigDecimal(1002));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
	}
}
