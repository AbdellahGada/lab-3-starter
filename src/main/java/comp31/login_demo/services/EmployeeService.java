
package comp31.login_demo.services;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    
    ArrayList<Employee> employeeList;

    public EmployeeService() {
        super();
        employeeList = new ArrayList<>();
    }


    public ArrayList <Employee> getAllEmployees(){
        return employeeList;
    }


    public void  addEmployee(String userId, String department){
        Employee emp = new Employee( userId,  department);
        employeeList.add(emp);
    }


    public String findDepartment(String userId)
    {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if(userId.equals(emp.userId))
            return emp.department;
        }
        return null;
    }
}
