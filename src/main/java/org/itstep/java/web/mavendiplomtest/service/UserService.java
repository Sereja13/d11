package org.itstep.java.web.mavendiplomtest.service;

import java.util.List;
import org.itstep.java.web.mavendiplomtest.model.User;

public interface UserService {

    boolean authorize(String name, String password);

    boolean deleteUser(Integer id);

    boolean edit(User u);

    User find(Integer id);

    List<User> findAll();

    User findByName(String name);

    List<User> findByNames(String name);

    boolean save(User u);
    
}
