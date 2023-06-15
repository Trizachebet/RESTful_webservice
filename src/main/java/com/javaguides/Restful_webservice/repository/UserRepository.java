package com.javaguides.Restful_webservice.repository;

import com.javaguides.Restful_webservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
