package br.com.cvc.verificacoes;

import br.com.cvc.model.Agendamento;
import br.com.cvc.operacoes.OperacaoA;
import br.com.cvc.operacoes.OperacaoB;
import br.com.cvc.operacoes.OperacaoC;
import br.com.cvc.operacoes.Operacoes;

public enum EnumOperacaoes {

	A {
		@Override
		public Operacoes operacao(Agendamento agendamento) {
			
			return new Operacoes(new OperacaoA(agendamento));
		}
	},
	B {
		@Override
		public Operacoes operacao(Agendamento agendamento) {
			
			return new Operacoes(new OperacaoB(agendamento));
			
		}
	},
	C {
		@Override
		public Operacoes operacao(Agendamento agendamento) {
			
			return new Operacoes(new OperacaoC(agendamento));
		}
	};
	
	public abstract Operacoes operacao(Agendamento agendamento);
}
