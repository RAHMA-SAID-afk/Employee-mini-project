package com.just.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 1. Get all employees
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployee();
    }
////2. Created an Employee
@PostMapping
public ResponseEntity<?> insertEmployee(@RequestBody Employee emp)   {
        employeeService.createEmployee(emp);
        String message = "Creation Operation successed. ";
        return ResponseEntity.status(HttpStatus.OK).body(message);

}
///// 3 . UPDATE EMPLOYEE
    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateEmployee(
            @PathVariable("id") long id , @RequestBody Employee emp){
                emp.setId(id);
                employeeService.updateEmployee(emp);
        Map<String, String> bodyDetail = Map.of("message", "employee has been successfuly updated");
        return ResponseEntity.status(HttpStatus.OK).body(bodyDetail);

    }
    //// 4 . Delete an Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteEmployee(@PathVariable("id") long id ){
        String message = "employee has been successfuly Deleted";
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }


    
}
