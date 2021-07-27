package com.herreralemus.store.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    String uuid;

    @Column(name="nombre", nullable = false)
    @Getter @Setter
    String nombre = "";

    @Column(name="descripcion")
    @Getter @Setter
    String descripcion = "";

    @Column(name="precio", nullable = false)
    @Getter @Setter
    Double precio = 0.00;

    @OneToMany(mappedBy = "producto")
    List<Orden> ordenes = new ArrayList<>();

    public Producto(){

    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, String descripcion, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
