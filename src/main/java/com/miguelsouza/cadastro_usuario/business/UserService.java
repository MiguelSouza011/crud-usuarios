package com.miguelsouza.cadastro_usuario.business;

import com.miguelsouza.cadastro_usuario.infrastructure.entitys.User;
import com.miguelsouza.cadastro_usuario.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.saveAndFlush(user);
    }

    public User findByEmail(String email) {

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUserEmail(String email, User user) {
        User userEntity = findByEmail(email);
        User UserUpdated = User.builder()
                .email(user.getEmail() != null ?
                        user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() :
                        userEntity.getName())
                .id(userEntity.getId())
                .build();

    }

    public void updateUserId(Integer id, User user) {
        User userEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encrontrado"));
        User userUpdated = User.builder()
                .email(user.getEmail() != null ? user.getEmail() :
                        userEntity.getEmail())
                .name(user.getName() != null ? user.getName() :
                        userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userUpdated);
    }
}
