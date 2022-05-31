package tr.edu.yildiz.ce.seuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.edu.yildiz.ce.seuser.domain.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findByEmail(String email);
}
