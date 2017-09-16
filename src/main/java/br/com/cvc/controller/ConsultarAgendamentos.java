package br.com.cvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cvc.db.Agendamentos;
import br.com.cvc.model.Agendamento;

@Controller
public class ConsultarAgendamentos {

	@RequestMapping("/getAgendamentos")
	@ResponseBody
	ResponseEntity<List<Agendamento>> gerAgendamentos(){
		
		return new ResponseEntity<List<Agendamento>>(Agendamentos.getInstance(), HttpStatus.OK);
	}
}
