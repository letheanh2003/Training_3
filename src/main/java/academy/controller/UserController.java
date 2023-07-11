package academy.controller;

import academy.model.User;
import academy.service.UserServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @Inject
    public UserServiceIMPL userServiceIMPL = new UserServiceIMPL();

    @GetMapping("/api/employee")
    public ResponseEntity<?> findAll() {
        List<User> employeeList = userServiceIMPL.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @GetMapping("/api/employee/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        User employee = userServiceIMPL.findById(id);
        if (employee==null){
            return new ResponseEntity<>("id not found, please try again!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/api/employee")
    public ResponseEntity<?> createEmployee(@RequestBody User user) {
        boolean checkEmail = userServiceIMPL.checkEmail(user.getEmail());
        if (checkEmail) {
            return new ResponseEntity<>("email existed, please try again! ", HttpStatus.FAILED_DEPENDENCY);
        }
        userServiceIMPL.save(user);
        return new ResponseEntity<>("create success fully!",HttpStatus.OK);
    }

    @PutMapping("/api/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody User user) {
        User userByEmail = userServiceIMPL.findByEmail(user.getEmail());
        if (userByEmail != null && userByEmail.getId() != userByEmail.getId()) {
            return new ResponseEntity<>("email existed, please try again! ",HttpStatus.NOT_FOUND);
        }
        userServiceIMPL.save(user);
        return new ResponseEntity<>("update success fully!",HttpStatus.OK);
    }

    @DeleteMapping("/api/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        boolean check = userServiceIMPL.deleteById(id);
        if (check) {
            return new ResponseEntity<>("delete success fully!",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("id not found, please try again! ", HttpStatus.NOT_FOUND);
        }
    }
}
