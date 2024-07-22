package com.just.Employee;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class EmployeeService {
    private final JdbcTemplate template;


        //1. read all employee from employee table in just db
        public List<Employee> getAllEmployee(){
        String sql = "SELECT * FROM Employee";
        return template.query(sql , new BeanPropertyRowMapper<>(Employee.class));
    }
    // 2. Craete an Employee
    public void createEmployee(Employee emp){
            // Sql query As String
        String sql = "INSERT INTO Employee (name , position, salary) VALUES(?, ?, ?)";
        int affected = template.update(sql, emp.getName(), emp.getPosition(), emp.getSalary());
        if (affected > 0)
            System.out.println("Employee has been successfuly created!");
        else
            System.out.println("Failed to be created");
    }
// 3 . Update an employee by id
    public void updateEmployee(Employee emp){
    // Sql query As String
    String sql = "UPDATE Employee SET name = ?, position = ?, salary = ? where id = ? ";
    int affected = template.update(sql, emp.getName(), emp.getPosition(), emp.getSalary(), emp.getId());
    if (affected > 0)
        System.out.println("Employee has been successfuly Updated!");
    else
        System.out.println("Failed to be Updated");
}

//// 4. Delete Employee by id

   public void deleteEmployee(long id){
    // Sql query As String
    String sql = "DELETE FROM  Employee where id = ?";
    int affected = template.update(sql, id);
    if (affected > 0)
        System.out.println("Employee has been successfuly deleted!");
    else
        System.out.println("Failed to be deleted");
}




}
