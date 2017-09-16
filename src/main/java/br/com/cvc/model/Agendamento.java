package br.com.cvc.model;

import java.math.BigDecimal;

public class Agendamento {

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private double taxa;
	private String dataTransferecia;
	private String dataAgendamento;
	private BigDecimal debtoTotal;
	
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
	public String getDataTransferecia() {
		return dataTransferecia;
	}
	public void setDataTransferecia(String dataTransferecia) {
		this.dataTransferecia = dataTransferecia;
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
	
	
}
