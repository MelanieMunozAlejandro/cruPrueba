package com.example.cruprueba.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSession")
    private Long idSession;

    @Column(name = "FechaIngreso", nullable = false)
    //private Date fechaIngreso;
    private String fechaIngreso;

    @Column(name = "FechaCierre", nullable = false)
    //private Date fechaCierre;
    private String fechaCierre;

    @Column(name = "usuarios_idUsuasio", nullable = false)
    private Integer usuariosIdUsuario;

    @ManyToOne
    @JoinColumn(name = "usuarios_idUsuasio", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    private Usuarios usuario;
}
