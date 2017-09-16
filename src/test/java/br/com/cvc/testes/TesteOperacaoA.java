package br.com.cvc.testes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoA;

public class TesteOperacaoA {

	@Test
	public void teste() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		ag.setDataAgendamento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		ag.setDataTransferecia("2017-09-16");
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(33, ag.getTaxa(),0);
	}
	
	@Test
	public void teste2() throws Exception{
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(10));
		ag.setDataAgendamento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		ag.setDataTransferecia("2017-09-16");
		
		
		OperacaoA op = new OperacaoA(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(3.3, ag.getTaxa(),0);
	}
}
