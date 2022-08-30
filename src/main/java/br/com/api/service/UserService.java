package br.com.api.service;

import br.com.api.model.User;
import br.com.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(new User());
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User updateEmailById(String email, int id) {
        User user = userRepository.findById(id).get();
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public void updateUserById(User user) {
        userRepository.deleteById(user.getId());
        userRepository.save(user);
    }
}
