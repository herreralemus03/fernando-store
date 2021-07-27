package com.herreralemus.store.repositories;

import com.herreralemus.store.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, String> {
}
