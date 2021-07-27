package com.herreralemus.store.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    String uuid;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @Getter @Setter
    Producto producto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @Getter @Setter
    Cliente cliente;

    @Column(name = "fecha")
    @Getter @Setter
    Long fecha;

    @Column(name = "cantidad")
    @Getter @Setter
    Integer cantidad = 0;

    public Orden(){

    }
}
