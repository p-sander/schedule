package com.project.schedule_official.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    List<User> findAll();

    Optional<User> findByName(String name);

    User findByUserId(Integer userId);

    User findUserByName(String name);

    User findUserByEmail(String email);

    void deleteById(Integer userId);

    void deleteAll();

}
