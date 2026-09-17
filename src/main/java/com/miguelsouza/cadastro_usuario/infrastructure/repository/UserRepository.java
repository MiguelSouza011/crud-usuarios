package com.miguelsouza.cadastro_usuario.infrastructure.repository;

import com.miguelsouza.cadastro_usuario.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
