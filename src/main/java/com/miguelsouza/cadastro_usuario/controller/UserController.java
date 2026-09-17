package com.miguelsouza.cadastro_usuario.controller;

import com.miguelsouza.cadastro_usuario.business.UserService;
import com.miguelsouza.cadastro_usuario.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tb_user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    /*
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    } */

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        service.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByEmail(@RequestParam String email) {
        service.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updatedUserId(@RequestParam Integer id,
                                            @RequestBody User user) {
        service.updateUserId(id, user);
        return ResponseEntity.ok().build();
    }

}
