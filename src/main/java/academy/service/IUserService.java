package academy.service;

import academy.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User save(User user);
}
