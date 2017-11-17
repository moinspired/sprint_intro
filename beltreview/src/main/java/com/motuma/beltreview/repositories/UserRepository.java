package com.motuma.beltreview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motuma.beltreview.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}