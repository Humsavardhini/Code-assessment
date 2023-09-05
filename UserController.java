package com.ford.spring.springbootuserproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        User u = new User();
        u.setUserId(u.getUserId());
        u.setUserName(u.getUserName());
        u.setUserEmail(user.getUserEmail());
        u.setGender(u.getGender());
        u.setAge(u.getAge());
        u.setNationality(u.getNationality());

        return u;
    }
    @GetMapping("/viewAll")
    public @ResponseBody Iterable<User> getAllUsers(){

        return userRepository.findAll();
    }
    @GetMapping("view/{id}")
    public Optional<User> getCustomer(@PathVariable Integer id)
    {

        return userRepository.findById(id);
    }

    @PutMapping("/edit/{id}")
    public Optional<String> update(@RequestBody User updateUser, @PathVariable Integer id){
        return userRepository.findById(id)
                .map(User ->{
                    User.setUserId(updateUser.getUserId());
                    User.setUserName(updateUser.getUserName());
                    User.setUserEmail(updateUser.getUserEmail());
                    User.setAge(updateUser.getAge());
                    User.setGender(updateUser.getGender());
                    User.setNationality(updateUser.getNationality());
                    userRepository.save(User);
                    return "User details updated successfully";

        });
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        userRepository.deleteById(id);
        return "User has been successfully deleted !!!!";
    }

}
