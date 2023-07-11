package academy.controller;

import academy.model.User;
import academy.service.UserServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @Inject
    private UserServiceIMPL userServiceIMPL;

    @GetMapping
    public List<User> findAllUsers() {
        return userServiceIMPL.findAll();
    }

    @PostMapping
    private User save(User user) {
        return userServiceIMPL.save(user);
    }
}
