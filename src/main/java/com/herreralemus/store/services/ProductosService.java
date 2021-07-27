package com.herreralemus.store.services;

import com.herreralemus.store.models.Producto;
import com.herreralemus.store.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductosService {
    @Autowired
    ProductosRepository productosRepository;
    public Producto add(Producto producto){
        return productosRepository.save(producto);
    }

    public Producto update(Producto producto){
        return productosRepository.save(producto);
    }

    public void delete(String uuid){
        if(uuid == null) return;
        productosRepository.deleteById(uuid);
    }

    public Page<Producto> getAll(Map<String, String> params){
        var page = Integer.parseInt(params.getOrDefault("page", "0"));
        var size = Integer.parseInt(params.getOrDefault("size", "25"));

        return productosRepository.findAll(PageRequest.of(page, size));
    }
}
