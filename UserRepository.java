package com.ford.spring.springbootuserproject;

import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

}
