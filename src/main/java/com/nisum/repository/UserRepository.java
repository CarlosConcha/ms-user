package com.nisum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nisum.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
