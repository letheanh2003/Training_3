package academy.service;


import academy.model.User;
import academy.repository.IUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Primary
@Order(1)
public class UserServiceIMPL {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "the anh", "the@gmail.com"));
        userList.add(new User(2, "minh khiet", "khiet@gmail.com"));
        userList.add(new User(3, "quang tuan", "tuan@gmail.com"));
    }


    public List<User> findAll() {
        return userList;
    }

    public User findById(int id) {
        for (User e : userList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void save(User user) {

        if (user.getId() == 0) {
            int id = userList.get(userList.size() - 1).getId() + 1;
            user.setId(id);
            userList.add(user);
        } else {
            userList.set(userList.indexOf(findById(user.getId())), user);
        }

    }

    public boolean deleteById(int id) {
        if (findById(id) == null) {
            return false;
        } else {
            userList.remove(findById(id));
        }
        return true;
    }

    public User findByEmail(String email) {
        for (User e : userList) {
            if (e.getEmail().equals(email)) {
                return e;
            }
        }
        return null;
    }

    public boolean checkEmail(String email) {
        for (User e : userList) {
            if (e.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
