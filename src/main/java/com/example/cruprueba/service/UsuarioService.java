package com.example.cruprueba.service;

import com.example.cruprueba.entity.Usuarios;
import com.example.cruprueba.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuarios createUser(Usuarios user) {
        String originalMail = user.getMail();
        String mail = originalMail;
        int suffix = 1;

        while (usuarioRepositorio.existsByMail(mail)) {
            mail = originalMail + suffix;
            suffix++;
        }

        user.setMail(mail);
        return usuarioRepositorio.save(user);
    }

    public Usuarios updateUser(Usuarios user) {
        return usuarioRepositorio.save(user);
    }

    public void deleteUser(Long userId) {
        usuarioRepositorio.deleteById(userId);
    }

    public Usuarios getUserById(Long userId) {
        return usuarioRepositorio.findById(userId).orElse(null);
    }
}
