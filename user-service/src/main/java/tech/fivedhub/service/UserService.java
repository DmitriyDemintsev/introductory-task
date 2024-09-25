package tech.fivedhub.service;

import tech.fivedhub.model.User;

public interface UserService {

    User getUserById(Long userId);

    User getUserByLastName(String lastName);
}
