package br.com.cvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cvc.db.Agendamentos;
import br.com.cvc.exceptions.ExceptionRegraDeNegocio;
import br.com.cvc.model.Agendamento;
import br.com.cvc.model.Response;
import br.com.cvc.operacoes.OperacaoD;


@Controller
public class CadastrarAgendamento {

	private final String DATE_PATTERN = "yyyy-MM-dd";
	private final String RESPONSE_MESSAGE = "Agendamento cadastrado com sucesso." ;
	
	@RequestMapping(value = "/cadastrarAgendamento", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Response> cadastrar(@RequestBody Agendamento agendamento) throws ExceptionRegraDeNegocio {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		agendamento.setDataAgendamento(LocalDate.now().format(formatter));
		
		new OperacaoD().operacaoD(agendamento);
		
		Agendamentos.getInstance().add(agendamento);
		
		Response response = new Response();
		
		response.setMessage(RESPONSE_MESSAGE);
		response.setCode(HttpStatus.OK.value());
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);		
	}
}
