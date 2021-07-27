package com.herreralemus.store.services;

import com.herreralemus.store.models.Cliente;
import com.herreralemus.store.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientesService {
    @Autowired
    ClientesRepository clientesRepository;

    public Cliente add(Cliente cliente){
        return clientesRepository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        return clientesRepository.save(cliente);
    }

    public void delete(String uuid){
        if(uuid == null) return;
        clientesRepository.deleteById(uuid);
    }

    public Page<Cliente> getAll(Map<String, String> params){
        var page = Integer.parseInt(params.getOrDefault("page", "0"));
        var size = Integer.parseInt(params.getOrDefault("size", "25"));

        return clientesRepository.findAll(PageRequest.of(page, size));
    }
}
