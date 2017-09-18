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
		ag.setDataTransferencia("2017-09-17");
		ag.setValor(new BigDecimal(10));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(3.3, ag.getTaxa().doubleValue(),0);
		Assert.assertEquals(13.3, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('A', ag.getOperacaoAplicada(),0);
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeExceptonOperacaoA() throws ExceptionRegraDeNegocio{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-09-18");
		ag.setValor(new BigDecimal(10));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
	}
	
	
	@Test
	public void testeOperacaoB() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-09-17");
		ag.setValor(new BigDecimal(1001));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(12, ag.getTaxa().doubleValue(),0);
		Assert.assertEquals(1013, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('B', ag.getOperacaoAplicada(),0);
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeExceptonOperacaoB() throws ExceptionRegraDeNegocio{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-09-29");
		ag.setValor(new BigDecimal(1002));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeExceptonOperacaoD() throws ExceptionRegraDeNegocio{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-09-29");
		ag.setValor(new BigDecimal(1000.40));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
	}
	
	@Test
	public void testeOperacaoCAcima10Dias() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-09-28");
		ag.setValor(new BigDecimal(2001));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(164.08, ag.getTaxa().doubleValue(),0);
		Assert.assertEquals(2165.08, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('C', ag.getOperacaoAplicada(),0);
	}
	
	@Test
	public void testeOperacaoCAcima20Dias() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-10-16");
		ag.setValor(new BigDecimal(3000));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(207, ag.getTaxa().doubleValue(),0);
		Assert.assertEquals(3207, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('C', ag.getOperacaoAplicada(),0);
	}
	
	@Test
	public void testeOperacaoCAcima30Dias() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-10-26");
		ag.setValor(new BigDecimal(3000));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(141, ag.getTaxa().doubleValue(),0);
		Assert.assertEquals(3141, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('C', ag.getOperacaoAplicada(),0);
	}
	
	@Test
	public void testeOperacaoCAcima40Dias() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia("2017-10-31");
		ag.setValor(new BigDecimal(3000));
		
		OperacaoD op = new OperacaoD();
		op.operacaoD(ag);
				
		Assert.assertEquals(51, ag.getTaxa().doubleValue(),0);
		Assert.assertEquals(3051, ag.getDebtoTotal().doubleValue(),0);
		Assert.assertEquals('C', ag.getOperacaoAplicada(),0);
	}
}
