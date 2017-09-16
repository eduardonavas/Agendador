package br.com.cvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cvc.db.Agendamentos;
import br.com.cvc.model.Agendamento;


@Controller
public class CadastrarAgendamento {

	@RequestMapping(value = "/cadastrarAgendamento", method = RequestMethod.POST)
	public ResponseEntity<Agendamento> cadastrar(@RequestBody Agendamento agendamento){
		Agendamentos.getInstance().add(agendamento);
		try{
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}
