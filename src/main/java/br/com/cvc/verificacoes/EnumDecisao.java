package br.com.cvc.verificacoes;

public enum EnumDecisao {

	ENUM_A{
		@Override
		public EnumOperacaoes decideOperacao(double valor) {
			
			if(valor > EnumValores.OPERACAO_A_MIN.getValor() && valor <= EnumValores.OPERACAO_A_MAX.getValor()){
				return EnumOperacaoes.A;
			}
			return null;
		}
	},
	ENUM_B {
		@Override
		public EnumOperacaoes decideOperacao(double valor) {
			
			if(valor >= EnumValores.OPERACAO_B_MIN.getValor() && valor <= EnumValores.OPERACAO_B_MAX.getValor()){
				return EnumOperacaoes.B;
			}
			return null;
		}
	},
	ENUM_C {
		@Override
		public EnumOperacaoes decideOperacao(double valor) {
			if(valor > EnumValores.OPERACAO_B_MAX.getValor()){
				return EnumOperacaoes.C;
			}
			return null;
		}
	};
	
	public abstract EnumOperacaoes decideOperacao(double valor);
}
