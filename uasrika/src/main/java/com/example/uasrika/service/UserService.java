
package com.example.uasrika.service;

import com.example.uasrika.model.User;
import com.example.uasrika.repository.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "User id not found"
                        ));
    }

    public User create(User user) {
        user.getDosen().setUser(user);
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        getById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}
