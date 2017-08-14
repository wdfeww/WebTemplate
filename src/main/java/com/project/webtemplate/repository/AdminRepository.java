package com.project.webtemplate.repository;

import com.project.webtemplate.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    public Admin getAdminByUsernameAndPassword(String username, String password);
}
