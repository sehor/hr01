package hr01.security.user;

import hr01.security.menu.Menu;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User getUser(Integer id);
    User getUser(String username);

    User updateUser(User user);

    void deleteUser(User user);
    void deleteUser(Integer id);

    List<User> getAllUser();

    List<Menu> getUsrMenusByUserId(Integer userId);
}