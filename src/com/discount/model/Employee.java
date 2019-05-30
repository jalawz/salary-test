package com.discount.model;

import java.math.BigDecimal;

public class Employee {

	private Integer clientId;
	private String clientName;
	private BigDecimal salary;
	private BigDecimal discount;
	private BigDecimal liquidSalary;

	public Employee() {
	};

	public Employee(Integer clientId, String clientName, BigDecimal salary, BigDecimal discount) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.salary = salary;
		this.discount = discount;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getLiquidSalary() {
		return liquidSalary;
	}

	public void setLiquidSalary() {
		this.liquidSalary = this.getSalary().subtract(this.getDiscount());
	}

}
