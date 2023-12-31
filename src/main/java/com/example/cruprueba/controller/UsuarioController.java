package com.example.cruprueba.controller;

import com.example.cruprueba.entity.Usuarios;
import com.example.cruprueba.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public Usuarios createUser(@RequestBody Usuarios user) {
        return usuarioService.createUser(user);
    }

    @PutMapping("/{userId}")
    public Usuarios updateUser(@PathVariable Long userId, @RequestBody Usuarios user) {
        user.setIdUsuario(userId);
        return usuarioService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        usuarioService.deleteUser(userId);
    }

    @GetMapping("/{userId}")
    public Usuarios getUserById(@PathVariable Long userId) {
        return usuarioService.getUserById(userId);
    }

}
