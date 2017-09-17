package br.com.cvc.model;

import java.math.BigDecimal;

public class Agendamento {

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private double taxa;
	private String dataTransferencia;
	private String dataAgendamento;
	private BigDecimal debtoTotal;
	private char operacaoAplicada;
	
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public String getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(String dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getDebtoTotal() {
		return debtoTotal;
	}
	public void setDebtoTotal(BigDecimal debtoTotal) {
		this.debtoTotal = debtoTotal;
	}
	public Character getOperacaoAplicada() {
		return operacaoAplicada;
	}
	public void setOperacaoAplicada(Character operacaoAplicada) {
		this.operacaoAplicada = operacaoAplicada;
	}
	public void setOperacaoAplicada(char operacaoAplicada) {
		this.operacaoAplicada = operacaoAplicada;
	}
}
