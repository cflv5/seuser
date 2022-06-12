package tr.edu.yildiz.ce.seuser.service.repository;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.edu.yildiz.ce.se.base.exception.SeBaseException;
import tr.edu.yildiz.ce.seuser.domain.entity.User;
import tr.edu.yildiz.ce.seuser.repository.UserRepository;

@Service
public class UserRepositoryService {
    private final UserRepository userRepository;

    public UserRepositoryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new SeBaseException("User not found", HttpStatus.NOT_FOUND));
    }

}
