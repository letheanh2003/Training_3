package academy.service;


import academy.model.User;
import academy.repository.IUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@Component
public class UserServiceIMPL implements IUserService {
    @Inject
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


}
