package br.com.cvc.testes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoB;

public class TesteOperacaoB {

	
	@Test
	public void teste() throws Exception{
		
Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(10));
		ag.setDataAgendamento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		ag.setDataTransferecia("2017-09-26");
		
		
		OperacaoB op = new OperacaoB(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(12, ag.getTaxa(),0);
		Assert.assertEquals(22, ag.getDebtoTotal().doubleValue(),0);
	}
	
	@Test
	public void teste2() throws Exception{
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		ag.setDataAgendamento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		ag.setDataTransferecia("2017-09-16");
		
		
		OperacaoB op = new OperacaoB(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(12, ag.getTaxa(),0);
		Assert.assertEquals(1012, ag.getDebtoTotal().doubleValue(),0);
	}
	
	@Test(expected = ExceptionRegraDeNegocio.class)
	public void testeException() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		ag.setDataAgendamento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		ag.setDataTransferecia("2017-09-30");
		
		
		OperacaoB op = new OperacaoB(ag);
		op.calcularTaxa();
	}
}
