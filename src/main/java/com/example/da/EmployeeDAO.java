package com.example.da;

import com.example.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/employees_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO Employee" + "(full_name, birthday, address, position, department) VALUES " + "(?,?,?,?,?)";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM Employee";


    public EmployeeDAO() {}

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    public void insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setString(5, employee.getDepartment());
            preparedStatement.executeUpdate();

    }

    public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fullName = resultSet.getString("full_name");
            String birthday = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String position = resultSet.getString("position");
            String department = resultSet.getString("department");

            employees.add(new Employee(id, fullName, birthday, address, position, department));
        }


        return employees;
    }
}
