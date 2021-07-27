package com.herreralemus.store.controllers;

import com.herreralemus.store.models.Cliente;
import com.herreralemus.store.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/clientes")
public class ClientesController {
    @Autowired
    ClientesService clientesService;

    @GetMapping(path = "/")
    public Page<Cliente> getAll(@RequestParam(required = false) Map<String, String> params){
        return clientesService.getAll(params);
    }

    @PostMapping(path = "add")
    public Cliente add(@RequestBody Cliente cliente){
        return clientesService.add(cliente);
    }

    @PostMapping(path = "update")
    public Cliente update(@RequestBody Cliente cliente){
        return clientesService.update(cliente);
    }

    @GetMapping(path = "delete/{uuid}")
    public void delete(@PathVariable(value = "uuid") String uuid){
        clientesService.delete(uuid);
    }
}
