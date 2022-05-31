package tr.edu.yildiz.ce.seuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.edu.yildiz.ce.seuser.domain.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}
