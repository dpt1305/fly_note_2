package aden.dev.site.fly_note.service;

import aden.dev.site.fly_note.entity.UserEntity;
import aden.dev.site.fly_note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
