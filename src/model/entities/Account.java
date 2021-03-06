package model.entities;

import model.exceptions.BusinessException;

public class Account {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Account() {
	}

	public Account(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;	
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito(double quantia) {
		saldo += quantia;
	}
	
	public void saque(double quantia) {
		validaLimiteSaque(quantia);
		saldo -= quantia;
	}
	
	private void validaLimiteSaque(double quantia) {
		if (quantia > getLimiteSaque()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		}
		if (quantia > getSaldo()) {
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
		
	}
	
}
