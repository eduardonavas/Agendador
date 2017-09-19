package br.com.cvc.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;


import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoC;

public class TesteOperacaoC {

	@Test
	public void testeAcima10dias() throws Exception{
		
		int dias = 11;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoC op = new OperacaoC(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(82, ag.getTaxa().doubleValue(),0);
	}
	
	@Test
	public void testeAcima20dias() throws Exception{
		
		int dias = 25;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoC op = new OperacaoC(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(69, ag.getTaxa().doubleValue(),0);
	}
	
	@Test
	public void testeAcima30dias() throws Exception{
		
		int dias = 36;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoC op = new OperacaoC(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(47, ag.getTaxa().doubleValue(),0);
	}
	
	@Test
	public void testeAcima40dias() throws Exception{
		
		int dias = 60;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoC op = new OperacaoC(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(17, ag.getTaxa().doubleValue(),0);
	}
	
}
