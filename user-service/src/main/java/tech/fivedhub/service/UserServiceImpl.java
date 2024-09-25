package tech.fivedhub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.fivedhub.exception.UserNotFoundException;
import tech.fivedhub.model.User;
import tech.fivedhub.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
