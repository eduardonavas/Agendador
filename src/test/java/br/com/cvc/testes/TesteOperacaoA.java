package br.com.cvc.testes;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoA;

public class TesteOperacaoA {

	@Test
	public void teste() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		ag.setDataTransferecia("2017-09-16");
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(33, ag.getTaxa(),0);
		Assert.assertEquals(1033, ag.getDebtoTotal().doubleValue(),0);
	}
	
	@Test
	public void teste2() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(10));
		ag.setDataTransferecia("2017-09-16");
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(3.3, ag.getTaxa(),0);
		Assert.assertEquals(13.3, ag.getDebtoTotal().doubleValue(),0);
	}
	
	@Test(expected=ExceptionRegraDeNegocio.class)
	public void testeExcpection() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(10));
		ag.setDataTransferecia("2017-09-17");
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
	}
}
