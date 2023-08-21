package com.example.cruprueba.service;

import com.example.cruprueba.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.cruprueba.repository.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class AutoService {
    @Autowired
    private UsuarioRepositorio usuariosRepositorio;


    public Usuarios authenticateUser(String username, String password) {
        Usuarios user = usuariosRepositorio.findByUserName(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public void logoutUser(Long userId) {
        Usuarios user = usuariosRepositorio.findById(userId).orElse(null);
        if (user != null) {
            user.setSessionActive('N');
            usuariosRepositorio.save(user);
        }
    }
}
