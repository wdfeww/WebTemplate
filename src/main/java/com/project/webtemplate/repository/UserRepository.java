package com.project.webtemplate.repository;

import com.project.webtemplate.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
