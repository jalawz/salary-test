package com.discount.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.discount.exception.CustomException;
import com.discount.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private Connection connection;
	
	public EmployeeDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT id_cliente, nm_cliente, vl_salario_bruto,"
				+ "(SELECT SUM(vl_desconto) FROM descontos WHERE funcionario.id_cliente = descontos.id_cliente) desconto from funcionario";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setClientId(rs.getInt("id_cliente"));
				employee.setClientName(rs.getString("nm_cliente"));
				employee.setSalary(rs.getBigDecimal("vl_salario_bruto"));
				employee.setDiscount(rs.getBigDecimal("desconto"));
				employee.setLiquidSalary();
				employees.add(employee);
			}
			
			connection.close();
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		
		return employees;
	}

}
