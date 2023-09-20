package comp31.login_demo.controllers;
import comp31.login_demo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    EmployeeService employeeService;

   public MainController(EmployeeService employeeService) 
   {
        super();
        this.employeeService = employeeService;
        employeeService.addEmployee("john_doe", "HR");
        employeeService.addEmployee("jane_smith", "IT");
        employeeService.addEmployee("mary_jones", "Finance");
   }

   @GetMapping("/")
   public String getRoot() {
      return "login";
   }

   @GetMapping("/login")
   public String getLogin(Model model, @RequestParam String userId) {
      model.addAttribute("userId", userId);
      String department = employeeService.findDepartment(userId);
      if(department == null)
            model.addAttribute("department","home");
      else 
            model.addAttribute("department",department);

            if(department == null)
                return "home"; 
            else 
                return "departments/" + department;
 }
}
