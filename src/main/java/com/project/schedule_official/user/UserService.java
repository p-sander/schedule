package com.project.schedule_official.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createNewUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    public User findById(Integer userId) {
        return userRepository.findByUserId(userId);
    }

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    //method will be allowed just for staff
    public void getAllNames() {
        List<User> list = userRepository.findAll();
        for (User oneUSerFromList : list) {
            System.out.println("NAME:" + oneUSerFromList.getName());
        }
    }

}