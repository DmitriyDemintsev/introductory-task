package tech.fivedhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.fivedhub.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLastName(String lastName);
}
