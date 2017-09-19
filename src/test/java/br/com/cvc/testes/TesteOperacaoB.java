package br.com.cvc.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoB;

public class TesteOperacaoB {

	
	@Test
	public void testeAgendamentoAte10Dias() throws Exception{
		
		int dias = 10;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(10));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoB op = new OperacaoB(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(12, ag.getTaxa().doubleValue(),0);
	}
	
	@Test
	public void testeAgendamentoMesmoDia() throws Exception{
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().format(formatter));
		
		
		OperacaoB op = new OperacaoB(ag);
		op.calcularTaxa();
				
		Assert.assertEquals(12, ag.getTaxa().doubleValue(),0);
		
	}
	
	@Test(expected = ExceptionRegraDeNegocio.class)
	public void testeAcima10Dias() throws Exception{
		
		int dias = 12;
		
		Agendamento ag = new Agendamento();
		
		ag.setValor(new BigDecimal(1000));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ag.setDataAgendamento(LocalDate.now().format(formatter));
		ag.setDataTransferencia(LocalDate.now().plusDays(dias).format(formatter));
		
		
		OperacaoB op = new OperacaoB(ag);
		op.calcularTaxa();
	}
}
