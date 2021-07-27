package com.herreralemus.store.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    String uuid;

    @Column(name="nombre", nullable = false)
    @Getter @Setter
    String nombre = "";

    @Column(name="apellido", nullable = false)
    @Getter @Setter
    String apellido = "";

    @Column(name = "nit", unique = true)
    @Getter @Setter
    String nit = "";

    @OneToMany(mappedBy = "cliente")
    List<Orden> ordenes = new ArrayList<>();

    public Cliente(){

    }

    public Cliente(String nombre, String apellido, String nit) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
