package br.com.cvc.db;

import java.util.ArrayList;

import br.com.cvc.model.Agendamento;



public class Agendamentos {

	private static ArrayList<Agendamento> agendamentos;
	
	public static ArrayList<Agendamento> getInstance(){
		
		if(agendamentos == null){
			agendamentos = new ArrayList<>();
		}
		
		return agendamentos;
	}
	
}
