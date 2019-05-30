package com.discount;

import java.util.List;

import com.discount.dao.EmployeeDaoImpl;
import com.discount.model.Employee;

public class MainProgram {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new EmployeeDaoImpl().getEmployees();
		employees.sort((emp1, emp2) -> emp2.getLiquidSalary().compareTo(emp1.getLiquidSalary()));
		
		for (Employee employee : employees) {
			System.out.println(String.format("Id: %d", employee.getClientId()));
			System.out.println(String.format("Nome: %s", employee.getClientName()));
			System.out.println(String.format("Salário Bruto: %s", employee.getSalary()));
			System.out.println(String.format("Descontos: %s", employee.getDiscount()));
			System.out.println(String.format("Salário Líquido: %s", employee.getLiquidSalary()));
			System.out.println("----------------------------------------");
		}
	}
}
