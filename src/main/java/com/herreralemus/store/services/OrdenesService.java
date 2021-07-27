package com.herreralemus.store.services;

import com.herreralemus.store.models.Orden;
import com.herreralemus.store.models.Producto;
import com.herreralemus.store.repositories.OrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrdenesService {

    @Autowired
    OrdenesRepository ordenesRepository;
    public Orden add(Orden orden){
        return ordenesRepository.save(orden);
    }

    public Orden update(Orden orden){
        return ordenesRepository.save(orden);
    }

    public void delete(String uuid){
        if(uuid == null) return;
        ordenesRepository.deleteById(uuid);
    }

    public Page<Orden> getAll(Map<String, String> params){
        var page = Integer.parseInt(params.getOrDefault("page", "0"));
        var size = Integer.parseInt(params.getOrDefault("size", "25"));

        return ordenesRepository.findAll(PageRequest.of(page, size));
    }
}
